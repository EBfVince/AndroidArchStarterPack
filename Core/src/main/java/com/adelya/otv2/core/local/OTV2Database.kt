package com.adelya.otv2.core.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.adelya.otv2.core.local.dao.EquipeDao
import com.adelya.otv2.core.local.dao.MatchDao
import com.adelya.otv2.core.model.Equipe
import com.adelya.otv2.core.model.Match

@Database(
    entities = [
        Match::class,
        Equipe::class
    ],
    version = 2,
    exportSchema = false
)
abstract class OTV2Database : RoomDatabase() {

    abstract fun matchDao(): MatchDao

    abstract fun equipeDao(): EquipeDao

}