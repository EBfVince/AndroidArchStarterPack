package com.ebfstudio.footballeuse.data.remote.api

import com.ebfstudio.footballeuse.data.remote.api.FoodiumService.Companion.FOODIUM_API_URL
import com.ebfstudio.footballeuse.model.Article
import retrofit2.http.GET

/**
 * Service to fetch Foodium posts using dummy end point [FOODIUM_API_URL].
 */
interface FoodiumService {

    @GET("/DummyFoodiumApi/api/posts/")
    suspend fun getPosts(): List<Article>

    companion object {
        const val FOODIUM_API_URL = "https://patilshreyas.github.io/"
    }
}
