package com.test.core.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.jraska.livedata.test
import com.test.core.local.dao.EquipeDao
import com.test.core.model.Equipe
import com.test.core.remote.EquipeDataSource
import com.test.core.repository.utils.Resource
import com.test.core.rules.CoroutinesMainDispatcherRule
import com.test.core.test.datasets.EquipeDataset.FAKE_EQUIPE
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response

@ExperimentalCoroutinesApi
class EquipeRepositoryTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var coroutinesMainDispatcherRule = CoroutinesMainDispatcherRule()

    private lateinit var equipeRepository: EquipeRepository
    private lateinit var observer: Observer<Resource<Equipe>>
    private val equipeDataSource = mockk<EquipeDataSource>()
    private val equipeDao = mockk<EquipeDao>(relaxed = true)

    @Before
    fun setup() {
        equipeRepository = EquipeRepository(equipeDataSource, equipeDao)
        observer = mockk(relaxed = true)
    }

    @Test
    fun `Get Equipe by ID`() {

        val equipeFake = FAKE_EQUIPE
        val id = 16

        val response = mockk<Response<Equipe.BobEquipe>>()
        every { response.body() } returns Equipe.BobEquipe(equipeFake)
        coEvery { equipeDataSource.fetchEquipe(id) } returns response

        coEvery { equipeDao.getEquipe(id) } returns equipeFake

        val live = runBlocking { equipeRepository.getEquipeById(id).test() }
        live.assertHasValue()
            .assertValueHistory(
                Resource.loading(null),
                Resource.loading(equipeFake),
                Resource.success(equipeFake)
            )

        coVerify(exactly = 1) { equipeDataSource.fetchEquipe(id) }
        coVerify(exactly = 2) { equipeDao.getEquipe(id) }

    }

}