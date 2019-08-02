package com.adelya.otv2.core.remote

import com.adelya.otv2.core.remote.api.EquipeService
import com.adelya.otv2.core.repository.EquipeRepository
import retrofit2.Response

class EquipeDataSource(private val equipeService: EquipeService) {

    suspend fun fetchEquipe(id: Int): Response<EquipeRepository.BobEquipe> =
        equipeService.getEquipe(id)

}