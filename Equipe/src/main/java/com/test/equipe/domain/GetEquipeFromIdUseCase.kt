package com.test.equipe.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.adelya.otv2.core.model.Equipe
import com.adelya.otv2.core.repository.EquipeRepository
import com.adelya.otv2.core.repository.utils.Resource

class GetEquipeFromIdUseCase(private val repository: EquipeRepository) {

    suspend operator fun invoke(id: Int): LiveData<Resource<Equipe>> =
        Transformations.map(repository.getEquipeById(idEquipe = id)) { it }

}