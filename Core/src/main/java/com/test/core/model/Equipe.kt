package com.test.core.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Equipe(

    @PrimaryKey
    val id: Int,

    val nom: String

) {

    data class BobEquipe(
        val equipe: Equipe
    )

}