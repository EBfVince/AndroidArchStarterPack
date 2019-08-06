package com.test.core.repository

import androidx.lifecycle.LiveData
import com.test.core.local.dao.EquipeDao
import com.test.core.model.Equipe
import com.test.core.remote.EquipeDataSource
import com.test.core.repository.utils.NetworkBoundResource
import com.test.core.repository.utils.Resource
import retrofit2.Response

class EquipeRepository(
    private val dataSource: EquipeDataSource,
    private val dao: EquipeDao
) {

    suspend fun getEquipeById(idEquipe: Int): LiveData<Resource<Equipe>> =
        object : NetworkBoundResource<Equipe, Equipe.BobEquipe>() {
            override fun processResponse(response: Equipe.BobEquipe): Equipe = response.equipe

            override suspend fun saveCallResults(items: Equipe) = dao.insert(items)

            override fun shouldFetch(data: Equipe?): Boolean = true

            override suspend fun loadFromDb(): Equipe = dao.getEquipe(idEquipe)

            override suspend fun createCallAsync(): Response<Equipe.BobEquipe> = dataSource.fetchEquipe(idEquipe)
        }.build().asLiveData()

}