package com.test.core.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Match(

    @PrimaryKey
    // @SerializedName("id")
    val id: Int,

    @Embedded(prefix = "equipeDom_")
    // @SerializedName("equipeDom")
    val equipeDom: Equipe,

    @Embedded(prefix = "equipeVis_")
    // @SerializedName("equipeVis")
    val equipeVis: Equipe,

    // @SerializedName("nbButsDom")
    val nbButsDom: Int,

    // @SerializedName("nbButsVis")
    val nbButsVis: Int

)