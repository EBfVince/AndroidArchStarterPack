package com.ebfstudio.footballeuse.ui.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

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
