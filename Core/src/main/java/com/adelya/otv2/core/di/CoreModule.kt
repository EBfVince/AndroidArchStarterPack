package com.adelya.otv2.core.di

import androidx.room.Room
import com.adelya.otv2.core.AppDispatchers
import com.adelya.otv2.core.local.OTV2Database
import com.adelya.otv2.core.remote.EquipeDataSource
import com.adelya.otv2.core.remote.MatchDataSource
import com.adelya.otv2.core.remote.api.EquipeService
import com.adelya.otv2.core.remote.api.MatchService
import com.adelya.otv2.core.repository.EquipeRepository
import com.adelya.otv2.core.repository.MatchRepository
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val DATABASE = named("DATABASE")
val localModule = module {

    single(DATABASE) {
        Room
        .databaseBuilder(androidApplication(), OTV2Database::class.java, "OTV2.db")
        .build()
    }

    factory { get<OTV2Database>(DATABASE).matchDao() }
    factory { get<OTV2Database>(DATABASE).equipeDao() }

}

fun createRemoteModule(baseUrl: String) = module {

    single {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    factory { get<Retrofit>().create(MatchService::class.java) }
    factory { get<Retrofit>().create(EquipeService::class.java) }

    factory { MatchDataSource(get()) }
    factory { EquipeDataSource(get()) }

}

val repositoryModule = module {

    factory { AppDispatchers(Dispatchers.Main, Dispatchers.IO) }

    factory { MatchRepository(get(), get()) }
    factory { EquipeRepository(get(), get()) }

}

