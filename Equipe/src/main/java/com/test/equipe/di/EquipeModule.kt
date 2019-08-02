package com.test.equipe.di

import com.test.equipe.EquipeViewModel
import com.test.equipe.domain.GetEquipeFromIdUseCase
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val equipeModule = module {
    factory { GetEquipeFromIdUseCase(get()) }
    viewModel { EquipeViewModel(get(), get()) }
}