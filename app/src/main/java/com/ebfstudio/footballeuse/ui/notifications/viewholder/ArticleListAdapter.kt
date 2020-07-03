package com.ebfstudio.footballeuse.ui.notifications.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.ebfstudio.footballeuse.R
import com.ebfstudio.footballeuse.databinding.ItemArticleBinding
import com.ebfstudio.footballeuse.model.Article
import com.ebfstudio.footballeuse.ui.common.list.DataBoundListAdapter

/**
 * Created by Vincent Guillebaud on 02/07/2020
 */
class ArticleListAdapter(
    private val callback: (Article) -> Unit
) : DataBoundListAdapter<Article, ItemArticleBinding>(diffCallback = DIFF_CALLBACK) {

    override fun createBinding(parent: ViewGroup): ItemArticleBinding {
        val binding = DataBindingUtil.inflate<ItemArticleBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_article,
            parent,
            false
        )

        binding.root.setOnClickListener {
            binding.article?.let { article ->
                callback.invoke(article)
            }
        }

        return binding
    }

    override fun bind(binding: ItemArticleBinding, item: Article) {
        binding.article = item
    }

    companion object {
        private val DIFF_CALLBACK by lazy {
            object : DiffUtil.ItemCallback<Article>() {
                override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean =
                    oldItem.id == newItem.id

                override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean =
                    oldItem == newItem
            }
        }
    }

}
