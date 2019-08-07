package com.test.core.remote

import com.test.core.remote.api.EquipeService
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.koin.test.inject
import java.net.HttpURLConnection

class EquipeServiceTest : BaseTest() {

    private val equipeService: EquipeService by inject()

    @Test
    fun `get equipe by id`() {

        mockHttpResponse(mockServer, "equipe_25.json", HttpURLConnection.HTTP_OK)
        val id = 25

        runBlocking {
            val equipe = equipeService.getEquipe(idEquipe = id).body()?.equipe
            Assert.assertEquals("Marseille", equipe?.nom)
        }

    }

    @Test
    fun `no equipe founded 404`() {

        mockHttpResponse(mockServer, "equipe_25.json", HttpURLConnection.HTTP_NOT_FOUND)
        val id = 25

        runBlocking {
            val resp = equipeService.getEquipe(idEquipe = id)
            Assert.assertNull(resp.body()?.equipe)
            Assert.assertEquals(404, resp.code())
        }

    }

}