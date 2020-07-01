package com.ebfstudio.footballeuse.data.local

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ebfstudio.footballeuse.model.Article

/**
 * Created by Vincent Guillebaud on 01/07/2020
 */
object DatabaseMigrations {

    const val DB_VERSION = 5

    val MIGRATION_1_2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE ${Article.TABLE_NAME} ADD COLUMN seen INTEGER")
        }
    }

    val MIGRATION_2_3 = object : Migration(2, 3) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE ${Article.TABLE_NAME} ADD COLUMN plop TEXT NOT NULL DEFAULT 'salut mec'")
        }
    }

    val MIGRATION_3_4 = object : Migration(3, 4) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE ${Article.TABLE_NAME} ADD COLUMN bro INTEGER NOT NULL DEFAULT 1")
        }
    }

    val MIGRATION_4_5 = object : Migration(4, 5) {
        override fun migrate(database: SupportSQLiteDatabase) {
            // Create the new table
            database.execSQL("CREATE TABLE articles_temp (id TEXT NOT NULL, title TEXT NOT NULL, author TEXT NOT NULL, body TEXT NOT NULL, imageUrl TEXT NOT NULL, PRIMARY KEY(id))")

            // Copy the data
            database.execSQL("INSERT INTO articles_temp (id, title, author, body, imageUrl) SELECT id, title, author, body, imageUrl FROM ${Article.TABLE_NAME}")

            // Remove the old table
            database.execSQL("DROP TABLE ${Article.TABLE_NAME}")

            // Change the table name to the correct one
            database.execSQL("ALTER TABLE articles_temp RENAME TO ${Article.TABLE_NAME}")
        }
    }

}