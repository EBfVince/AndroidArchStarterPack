package com.adelya.otv2.core.remote.api

import com.adelya.otv2.core.repository.EquipeRepository
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface EquipeService {

    @GET("api/v2/equipe/{idEquipe}")
    suspend fun getEquipe(@Path("idEquipe") idEquipe: Int): Response<EquipeRepository.BobEquipe>

}