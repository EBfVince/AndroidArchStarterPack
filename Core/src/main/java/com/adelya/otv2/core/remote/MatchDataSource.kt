package com.adelya.otv2.core.remote

import com.adelya.otv2.core.model.Match
import com.adelya.otv2.core.remote.api.MatchService
import retrofit2.Response

class MatchDataSource(private val matchService: MatchService) {

    suspend fun fetchMatch(id: Int): Response<Match> =
        matchService.getMatch(idMatch = id)

}