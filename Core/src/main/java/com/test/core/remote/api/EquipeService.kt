package com.test.core.remote.api

import com.test.core.model.Equipe
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface EquipeService {

    @GET("api/v2/equipe/{idEquipe}")
    suspend fun getEquipe(@Path("idEquipe") idEquipe: Int): Response<Equipe.BobEquipe>

}