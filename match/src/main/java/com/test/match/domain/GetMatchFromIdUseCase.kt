package com.test.match.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.adelya.otv2.core.model.Match
import com.adelya.otv2.core.repository.MatchRepository
import com.adelya.otv2.core.repository.utils.Resource

class GetMatchFromIdUseCase(private val repository: MatchRepository) {

    suspend operator fun invoke(id: Int): LiveData<Resource<Match>> =
        Transformations.map(repository.getMatchById(idMatch = id)) { it }

}