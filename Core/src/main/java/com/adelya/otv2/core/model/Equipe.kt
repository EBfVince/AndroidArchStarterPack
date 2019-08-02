package com.adelya.otv2.core.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Equipe(

    @PrimaryKey
    val id: Int,

    val nom: String

)