package com.ebfstudio.footballeuse.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Vincent Guillebaud on 01/07/2020
 */
@Entity(tableName = Article.TABLE_NAME)
data class Article(

    @PrimaryKey
    val id: String,

    val title: String,
    val author : String,
    val body: String,
    val imageUrl: String,
    var seen: Int?,
    val plop: String,
    val bro: Boolean

) {

    companion object {
        const val TABLE_NAME = "Article"
    }

}