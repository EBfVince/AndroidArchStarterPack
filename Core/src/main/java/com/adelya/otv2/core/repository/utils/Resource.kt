package com.adelya.otv2.core.repository.utils

import android.content.Context
import android.util.Log
import com.adelya.otv2.core.R


/**
 * La classe resource permet de connaître le statut d'une donnée.
 * @param <T> Le type de l'objet dont on veut préciser le statut
</T> */
class Resource<out T> private constructor(
    val status: Status,
    val data: T?,
    private val errorReason: ErrorReason
) {

    companion object {

        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, ErrorReason.UNKNOWN)
        }

        fun <T> error(error: ErrorReason, data: T? = null): Resource<T> {
            return Resource(Status.ERROR, data, error)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, ErrorReason.UNKNOWN)
        }

    }

    fun getMessage(context: Context?): String {

        if (context == null) {
            Log.w("Resource", "getMessage(context) le context est null... relou --')")
            return ""
        }

        val ok: Int = when (errorReason) {
            ErrorReason.UNKNOWN -> R.string.erreur_inconnue
            ErrorReason.NO_INTERNET -> R.string.erreur_connexion_internet
            ErrorReason.API_RESPONSE_ERROR -> R.string.erreur_api
            ErrorReason.NO_RESPONSE -> R.string.erreur_serveur_inaccessible
        }

        return context.getString(ok)

    }

    fun onSuccess(f: (T) -> Unit) {
        if (status == Status.SUCCESS && data != null) {
            f(data)
        }
    }

    override fun toString(): String {
        return "Resource(status=$status, data=$data, errorReason=$errorReason)"
    }

}