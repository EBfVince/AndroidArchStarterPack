package com.ebfstudio.footballeuse.ui.notifications.binding

import android.view.View
import androidx.databinding.BindingAdapter

/**
 * Created by Vincent Guillebaud on 02/07/2020
 */
object BindingAdapter {

    @BindingAdapter("app:visibleGone")
    @JvmStatic
    fun visibleGone(view: View, show: Boolean) {
        view.visibility = if (show) View.VISIBLE else View.GONE
    }

}
