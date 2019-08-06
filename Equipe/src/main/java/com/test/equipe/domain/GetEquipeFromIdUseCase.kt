package com.test.equipe.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.test.core.model.Equipe
import com.test.core.repository.EquipeRepository
import com.test.core.repository.utils.Resource

class GetEquipeFromIdUseCase(private val repository: EquipeRepository) {

    suspend operator fun invoke(id: Int): LiveData<Resource<Equipe>> =
        Transformations.map(repository.getEquipeById(idEquipe = id)) { it }

}