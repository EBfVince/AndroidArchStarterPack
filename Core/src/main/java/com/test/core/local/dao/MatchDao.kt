package com.test.core.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.test.core.model.Match

@Dao
interface MatchDao : BaseDao<Match> {

    @Query("SELECT * FROM `Match` WHERE id = :id")
    suspend fun getMatch(id: Int): Match?

}