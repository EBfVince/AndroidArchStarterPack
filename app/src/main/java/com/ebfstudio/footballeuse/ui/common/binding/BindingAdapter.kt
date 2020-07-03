package com.ebfstudio.footballeuse.ui.common.binding

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.ebfstudio.footballeuse.model.utils.Resource

/**
 * Created by Vincent Guillebaud on 02/07/2020
 */
object BindingAdapter {

    @BindingAdapter("app:visibleGone")
    @JvmStatic
    fun visibleGone(view: View, show: Boolean) {
        view.visibility = if (show) View.VISIBLE else View.GONE
    }

    @BindingAdapter("app:imageUrl")
    @JvmStatic
    fun bindImage(imageView: ImageView, url: String?) {
        Glide.with(imageView.context)
            .load(url)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(imageView)
    }

    @BindingAdapter("app:items")
    @JvmStatic
    fun <T> items(recyclerView: RecyclerView, resource: Resource<List<T>>?) {

        // If the list is null, we return. It prevents blinking
        if (resource?.data == null)
            return

        @Suppress("UNCHECKED_CAST")
        val adapter = recyclerView.adapter as? ListAdapter<T, *>
        adapter?.submitList(resource.data.toMutableList())
    }

}
