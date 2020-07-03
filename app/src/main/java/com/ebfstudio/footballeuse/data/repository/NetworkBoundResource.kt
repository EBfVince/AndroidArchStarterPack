package com.ebfstudio.footballeuse.data.repository

import android.util.Log
import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import java.net.UnknownHostException

/**
 * Created by Vincent Guillebaud on 01/07/2020
 */
@ExperimentalCoroutinesApi
abstract class NetworkBoundResource<ResultType, RequestType> {

    fun asFlow() = flow<Resource<ResultType>> {

        // Emit Loading State
        emit(Resource.loading())

        try {

            // Emit Database content first
            val dbValue = loadFromDb().first()

            // Should update data with internet ?
            if (shouldFetch(dbValue)) {

                // Emit database temp value
                emit(Resource.loading(dbValue))

                // Fetch latest data from remote
                val apiResponse = fetchFromRemote()

                // Save the result
                saveNetworkResult(apiResponse)

            }

            // Emit the data from the db
            try {
                emitAll(loadFromDb().map { Resource.success(it) })
            } catch (jobException: CancellationException) {
            }

        } catch (e: Exception) {

            // Do something when an error occurred
            onFetchFailed(e)

            val error: ErrorReason = when (e) {
                is UnknownHostException -> ErrorReason.NO_INTERNET
                else -> ErrorReason.UNKNOWN.also {
                    Log.e(
                        "NetworkBoundResource",
                        e.message ?: "erreur"
                    )
                }.also { e.printStackTrace() }
            }

            // Emit db data with error status
            emitAll(loadFromDb().map { Resource.error(error, it) })

        }

    }.flowOn(Dispatchers.IO)

    @MainThread
    protected abstract fun loadFromDb(): Flow<ResultType>

    @WorkerThread
    protected abstract suspend fun fetchFromRemote(): RequestType

    @WorkerThread
    protected abstract suspend fun saveNetworkResult(item: RequestType)

    @MainThread
    protected open fun shouldFetch(data: ResultType?): Boolean = true

    protected open fun onFetchFailed(e: Exception) {}

}