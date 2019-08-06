package com.test.core.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Equipe(

    @PrimaryKey
    // @SerializedName("id")
    val id: Int,

    // @SerializedName("nom")
    val nom: String

) {

    data class BobEquipe(
        val equipe: Equipe
    )

}