package com.test.core.local

import com.test.core.test.datasets.EquipeDataset.FAKE_EQUIPES
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class EquipeDaoTest : BaseTest() {

    override fun setUp(){
        super.setUp()
        fillDatabase()
    }

    @Test
    fun getEquipeById() = runBlocking {
        val equipeFake = FAKE_EQUIPES.first()
        val id = equipeFake.id
        val equipe = database.equipeDao().getEquipe(id = id)
        Assert.assertEquals(equipeFake, equipe)
    }

    @Test
    fun getEquipeById2() = runBlocking {
        val equipeFake = FAKE_EQUIPES.first()
        val id = equipeFake.id
        val equipe = database.equipeDao().getEquipe(id = id)
        Assert.assertNotEquals(FAKE_EQUIPES.last(), equipe)
    }


    private fun fillDatabase() {
        runBlocking {
            database.equipeDao().insert(FAKE_EQUIPES)
        }
    }

}