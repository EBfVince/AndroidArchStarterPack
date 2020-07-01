package com.ebfstudio.footballeuse.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ebfstudio.footballeuse.model.Article
import kotlinx.coroutines.flow.Flow

/**
 * Created by Vincent Guillebaud on 01/07/2020
 */
@Dao
interface ArticlesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticles(articles: List<Article>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(article: Article)

    @Query("DELETE FROM ${Article.TABLE_NAME}")
    fun deleteAllArticles()

    @Query("SELECT * FROM ${Article.TABLE_NAME} WHERE id = :articleId")
    fun getArticleById(articleId: Int): Flow<Article>

    @Query("SELECT * FROM ${Article.TABLE_NAME}")
    fun getAllArticles(): Flow<List<Article>>

}