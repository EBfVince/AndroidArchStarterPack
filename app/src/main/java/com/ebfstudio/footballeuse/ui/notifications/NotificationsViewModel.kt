package com.ebfstudio.footballeuse.ui.notifications

import androidx.lifecycle.ViewModel
import com.ebfstudio.footballeuse.data.repository.ArticleRepository
import com.ebfstudio.footballeuse.extension.action
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class NotificationsViewModel(
    private val repo: ArticleRepository
) : ViewModel() {

    val articles = action {
        repo.getAllPosts()
    }

    init {
        articles.run()
    }

}