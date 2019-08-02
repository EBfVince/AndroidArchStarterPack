package com.adelya.otv2.core.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Match(

    @PrimaryKey
    val id: Int,

    @Embedded(prefix = "equipeDom_")
    val equipeDom: Equipe,

    @Embedded(prefix = "equipeVis_")
    val equipeVis: Equipe,

    val nbButsDom: Int,
    val nbButsVis: Int

)