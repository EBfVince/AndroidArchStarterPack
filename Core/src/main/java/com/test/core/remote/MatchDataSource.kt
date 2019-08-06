package com.test.core.remote

import com.test.core.model.Match
import com.test.core.remote.api.MatchService
import retrofit2.Response

class MatchDataSource(private val matchService: MatchService) {

    suspend fun fetchMatch(id: Int): Response<Match> =
        matchService.getMatch(idMatch = id)

}