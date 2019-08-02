package com.test.equipe

import androidx.lifecycle.*
import com.adelya.otv2.core.AppDispatchers
import com.adelya.otv2.core.model.Equipe
import com.adelya.otv2.core.repository.utils.Resource
import com.test.corebase.base.BaseViewModel
import com.test.equipe.domain.GetEquipeFromIdUseCase
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EquipeViewModel(
    dispatchers: AppDispatchers,
    private val getEquipeFromIdUseCase: GetEquipeFromIdUseCase
) : BaseViewModel() {


    private var idEquipe: Int = -1

    /*private val _equipe = MediatorLiveData<Resource<Equipe>>()
    val equipe: LiveData<Resource<Equipe>> get() = _equipe
    private var equipeSource: LiveData<Resource<Equipe>> = MutableLiveData()

    val match: LiveData<Resource<Match>> by Vince()

    fun loadEquipe(idEquipe: Int) {
        this.idEquipe = idEquipe
        getEquipe()
    }

    private fun getEquipe() = viewModelScope.launch(dispatchers.main) {
        _equipe.removeSource(equipeSource)
        equipeSource = withContext(dispatchers.io) { getEquipeFromIdUseCase(idEquipe) }
        _equipe.addSource(equipeSource) {
            _equipe.value = it
        }
    }*/



    private val _equipe = Vince(this, dispatchers) { getEquipeFromIdUseCase(idEquipe) }
    val equipe: LiveData<Resource<Equipe>> get() = _equipe.data

    fun loadEquipe(idEquipe: Int) {
        this.idEquipe = idEquipe
        _equipe.getData()
    }





    class Vince<T>(
        private val viewModel: ViewModel,
        private val dispatchers: AppDispatchers,
        private val process: suspend () -> LiveData<Resource<T>>
    ) {

        private var dataSource: LiveData<Resource<T>> = MutableLiveData()
        private val _data = MediatorLiveData<Resource<T>>()
        val data: LiveData<Resource<T>> get() = _data

        fun getData() = viewModel.viewModelScope.launch(dispatchers.main) {
            _data.removeSource(dataSource)
            dataSource = withContext(dispatchers.io) { process() }
            _data.addSource(dataSource) {
                _data.value = it
            }
        }

    }

}