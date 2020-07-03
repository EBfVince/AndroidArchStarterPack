package com.ebfstudio.footballeuse.model.utils

/**
 * Created by Vincent Guillebaud on 01/07/2020
 */
data class Resource<out DataType>(
    val status: Status,
    val data: DataType?,
    val error: ErrorReason
) {

    fun isLoading() = status == Status.LOADING

    companion object {

        fun <T> success(data: T?): Resource<T> =
            Resource(
                status = Status.SUCCESS,
                data = data,
                error = ErrorReason.UNKNOWN
            )

        fun <T> loading(data: T? = null): Resource<T> =
            Resource(
                status = Status.LOADING,
                data = data,
                error = ErrorReason.UNKNOWN
            )

        fun <T> error(error: ErrorReason, data: T? = null): Resource<T> =
            Resource(
                status = Status.ERROR,
                data = data,
                error = error
            )

    }

}
