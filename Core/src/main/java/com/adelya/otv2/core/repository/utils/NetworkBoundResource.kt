package com.adelya.otv2.core.repository.utils

import android.util.Log
import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import retrofit2.Response
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import kotlin.coroutines.coroutineContext

abstract class NetworkBoundResource<ResultType, RequestType> {

    private val result = MutableLiveData<Resource<ResultType>>()
    private val supervisorJob = SupervisorJob()

    suspend fun build(): NetworkBoundResource<ResultType, RequestType> {

        // Loading data
        withContext(Dispatchers.Main) {
            result.value = Resource.loading(null)
        }

        // En tâche de fond
        CoroutineScope(coroutineContext).launch(supervisorJob) {

            // On récupère le cache du tel
            val dbResult = loadFromDb()

            // Actualiser les données depuis internet ?
            if (shouldFetch(dbResult)) {

                // Dispatch latest value quickly (UX purpose)
                setValue(Resource.loading(dbResult))
                fetchFromNetwork()

            } else {
                setValue(Resource.success(dbResult))
            }
        }

        return this

    }

    fun asLiveData() = result as LiveData<Resource<ResultType>>

    // ---

    private suspend fun fetchFromNetwork() {

        try {

            // Execute l'appel API
            val rep = createCallAsync()

            // Enregistre en cache les résultats
            saveCallResults(processResponse(rep.body()!!))

            // Récupère depuis le cache les derniers résultats
            setValue(Resource.success(loadFromDb()))

        } catch (e: Exception) {

            Log.e("NetworkBoundResource", "${e.message}")

            // Erreur, on affiche le cache
            val error = detectError(e)
            setValue(Resource.error(error, loadFromDb()))

        }

    }

    private fun detectError(error: Throwable): ErrorReason = when (error) {

        // lorsque le site de l'API n'est pas accessible
        is SocketTimeoutException -> ErrorReason.NO_RESPONSE

        // lorsqu'il n'y a pas internet
        is UnknownHostException -> ErrorReason.NO_INTERNET

        // lorsque le retour de l'api ne correspond pas au retour attendu
        is IllegalStateException -> ErrorReason.API_RESPONSE_ERROR

        // Une erreur inconnue à traiter
        else -> ErrorReason.UNKNOWN

    }


    @WorkerThread
    private fun setValue(newValue: Resource<ResultType>) {
        if (result.value != newValue) {
            result.postValue(newValue)
        }
    }

    @WorkerThread
    protected abstract fun processResponse(response: RequestType): ResultType

    @WorkerThread
    protected abstract suspend fun saveCallResults(items: ResultType)

    @MainThread
    protected abstract fun shouldFetch(data: ResultType?): Boolean

    @WorkerThread
    protected abstract suspend fun loadFromDb(): ResultType

    @WorkerThread
    protected abstract suspend fun createCallAsync(): Response<RequestType>

}