package com.test.core.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.test.core.local.dao.EquipeDao
import com.test.core.local.dao.MatchDao
import com.test.core.model.Equipe
import com.test.core.model.Match

@Database(
    entities = [
        Match::class,
        Equipe::class
    ],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun matchDao(): MatchDao

    abstract fun equipeDao(): EquipeDao

}