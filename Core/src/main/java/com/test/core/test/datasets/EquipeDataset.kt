package com.test.core.test.datasets

import com.test.core.model.Equipe

object EquipeDataset {

    val FAKE_EQUIPES = listOf(
        Equipe(id = 1, nom = "Equipe 1"),
        Equipe(id = 2, nom = "Equipe 2"),
        Equipe(id = 3, nom = "Equipe 3")
    )

    val FAKE_EQUIPE = Equipe(id = 26, nom = "Bro")

}