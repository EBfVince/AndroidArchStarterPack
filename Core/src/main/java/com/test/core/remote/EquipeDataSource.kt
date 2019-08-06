package com.test.core.remote

import com.test.core.model.Equipe
import com.test.core.remote.api.EquipeService
import retrofit2.Response

class EquipeDataSource(private val equipeService: EquipeService) {

    suspend fun fetchEquipe(id: Int): Response<Equipe.BobEquipe> =
        equipeService.getEquipe(id)

}