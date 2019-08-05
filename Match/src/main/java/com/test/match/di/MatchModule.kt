package com.test.match.di

import com.test.match.MatchViewModel
import com.test.match.domain.GetMatchFromIdUseCase
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val matchModule = module {
    factory { GetMatchFromIdUseCase(get()) }
    viewModel { MatchViewModel(get(), get()) }
}