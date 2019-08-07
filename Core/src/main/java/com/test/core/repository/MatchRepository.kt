package com.test.core.repository

import androidx.lifecycle.LiveData
import com.test.core.local.dao.MatchDao
import com.test.core.model.Match
import com.test.core.remote.MatchDataSource
import com.test.core.repository.utils.NetworkBoundResource
import com.test.core.repository.utils.Resource
import retrofit2.Response

class MatchRepository(
    private val dataSource: MatchDataSource,
    private val dao: MatchDao
) {

    suspend fun getMatchById(idMatch: Int): LiveData<Resource<Match>> =
        object : NetworkBoundResource<Match, Match>() {
            override fun processResponse(response: Match): Match = response

            override suspend fun saveCallResults(items: Match) = dao.insert(items)

            override fun shouldFetch(data: Match?): Boolean = true

            override suspend fun loadFromDb(): Match? = dao.getMatch(idMatch)

            override suspend fun createCallAsync(): Response<Match> = dataSource.fetchMatch(idMatch)
        }.build().asLiveData()

}