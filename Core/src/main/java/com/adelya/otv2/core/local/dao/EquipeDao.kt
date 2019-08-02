package com.adelya.otv2.core.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.adelya.otv2.core.model.Equipe

@Dao
interface EquipeDao : BaseDao<Equipe> {

    @Query("SELECT * FROM Equipe WHERE id = :id")
    suspend fun getEquipe(id: Int): Equipe

}