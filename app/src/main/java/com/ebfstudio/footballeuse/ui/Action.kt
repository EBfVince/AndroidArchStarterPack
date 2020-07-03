package com.ebfstudio.footballeuse.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

/**
 * Created by Vincent Guillebaud on 03/07/2020
 */
class Action<T>(
    private val coroutineScope: CoroutineScope,
    private val action: () -> Flow<T>
) {

    val data: LiveData<T>
        get() = _data

    private var job: Job? = null
    private val _data = MediatorLiveData<T>()

    fun run() {

        // We cancel old job
        if (job?.isActive == true)
            job?.cancel()

        // We launch the new job
        job = coroutineScope.launch {
            action().collect {
                _data.value = it
            }
        }

    }

}

fun <T> ViewModel.action(action: () -> Flow<T>): Action<T> = Action(viewModelScope, action)

/**
 * Only proceed with the given action if the coroutine has not been cancelled.
 * Necessary because Flow.collect receives items even after coroutine was cancelled
 * https://github.com/Kotlin/kotlinx.coroutines/issues/1265
 */
suspend inline fun <T> Flow<T>.safeCollect(crossinline action: suspend (T) -> Unit) {
    collect {
        coroutineContext.ensureActive()
        action(it)
    }
}