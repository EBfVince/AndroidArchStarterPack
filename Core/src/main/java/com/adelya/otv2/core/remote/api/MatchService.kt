package com.adelya.otv2.core.remote.api

import com.adelya.otv2.core.model.Match
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MatchService {

    @GET("api/v2/match/{idMatch}")
    suspend fun getMatch(@Path("idMatch") idMatch: Int): Response<Match>

}