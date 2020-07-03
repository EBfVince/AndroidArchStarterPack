package com.ebfstudio.footballeuse.extension

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ebfstudio.footballeuse.ui.common.Action
import kotlinx.coroutines.flow.Flow

/**
 * Created by Vincent Guillebaud on 03/07/2020
 */

fun <T> ViewModel.action(action: () -> Flow<T>): Action<T> =
    Action(viewModelScope, action)
