package com.ebfstudio.footballeuse.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ebfstudio.footballeuse.data.local.dao.ArticlesDao
import com.ebfstudio.footballeuse.model.Article

/**
 * Created by Vincent Guillebaud on 01/07/2020
 */
@Database(
    entities = [Article::class],
    version = DatabaseMigrations.DB_VERSION
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun articleDao(): ArticlesDao

}
