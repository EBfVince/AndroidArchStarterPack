package com.adelya.otv2.core.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.adelya.otv2.core.model.Match

@Dao
interface MatchDao : BaseDao<Match> {

    @Query("SELECT * FROM `Match` WHERE id = :id")
    suspend fun getMatch(id: Int): Match

}