package com.adelya.otv2.core.repository

import androidx.lifecycle.LiveData
import com.adelya.otv2.core.local.dao.EquipeDao
import com.adelya.otv2.core.model.Equipe
import com.adelya.otv2.core.remote.EquipeDataSource
import com.adelya.otv2.core.repository.utils.NetworkBoundResource
import com.adelya.otv2.core.repository.utils.Resource
import retrofit2.Response

class EquipeRepository(
    private val dataSource: EquipeDataSource,
    private val dao: EquipeDao
) {

    suspend fun getEquipeById(idEquipe: Int): LiveData<Resource<Equipe>> =
        object : NetworkBoundResource<Equipe, BobEquipe>() {
            override fun processResponse(response: BobEquipe): Equipe = response.equipe

            override suspend fun saveCallResults(items: Equipe) = dao.insert(items)

            override fun shouldFetch(data: Equipe?): Boolean = true

            override suspend fun loadFromDb(): Equipe = dao.getEquipe(idEquipe)

            override suspend fun createCallAsync(): Response<BobEquipe> = dataSource.fetchEquipe(idEquipe)
        }.build().asLiveData()


    data class BobEquipe(
        val equipe: Equipe
    )

}