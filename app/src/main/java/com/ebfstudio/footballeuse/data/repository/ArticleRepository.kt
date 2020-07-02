package com.ebfstudio.footballeuse.data.repository

import com.ebfstudio.footballeuse.data.local.dao.ArticlesDao
import com.ebfstudio.footballeuse.data.remote.api.FoodiumService
import com.ebfstudio.footballeuse.model.Article
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

/**
 * Created by Vincent Guillebaud on 02/07/2020
 */
@ExperimentalCoroutinesApi
class ArticleRepository(
    private val articleDao: ArticlesDao,
    private val foodiumService: FoodiumService
) {

    /**
     * Fetched the posts from network and stored it in database. At the end, data from persistence
     * storage is fetched and emitted.
     */
    fun getAllPosts(): Flow<Resource<List<Article>>> {
        return object : NetworkBoundResource<List<Article>, List<Article>>() {
            override fun loadFromDb(): Flow<List<Article>> =
                articleDao.getAllArticles()

            override suspend fun fetchFromRemote(): List<Article> =
                foodiumService.getPosts()

            override suspend fun saveNetworkResult(item: List<Article>) =
                articleDao.insertArticles(item)
        }.asFlow()
    }

}