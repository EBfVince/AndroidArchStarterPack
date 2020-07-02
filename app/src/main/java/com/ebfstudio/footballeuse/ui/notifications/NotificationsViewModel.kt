package com.ebfstudio.footballeuse.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ebfstudio.footballeuse.data.repository.ArticleRepository
import com.ebfstudio.footballeuse.data.repository.Resource
import com.ebfstudio.footballeuse.model.Article
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class NotificationsViewModel(
    private val repo: ArticleRepository
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text


    val articles: LiveData<Resource<List<Article>>> =
        repo.getAllPosts().asLiveData()

}