package com.test.match

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.viewModelScope
import com.adelya.otv2.core.AppDispatchers
import com.adelya.otv2.core.model.Equipe
import com.adelya.otv2.core.model.Match
import com.adelya.otv2.core.repository.MatchRepository
import com.adelya.otv2.core.repository.utils.Resource
import com.test.corebase.base.BaseViewModel
import kotlinx.coroutines.launch

class MatchViewModel(
    private val dispatchers: AppDispatchers,
    private val matchRepository: MatchRepository
) : BaseViewModel() {

    private val _match = MediatorLiveData<Resource<Match>>()
    val match: LiveData<Resource<Match>> get() = _match

    init {
        getMatch()
    }


    fun clickOnBtn(equipe: Equipe) =
        navigate(MatchFragmentDirections.actionMatchFragmentToEquipeFragment(equipe.id))


    private fun getMatch() = viewModelScope.launch(dispatchers.main) {
        _match.addSource(matchRepository.getMatchById(5)) {
            _match.value = it
        }
    }

}