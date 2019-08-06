package com.test.core.di

import androidx.room.Room
import com.test.core.AppDispatchers
import com.test.core.local.AppDatabase
import com.test.core.remote.EquipeDataSource
import com.test.core.remote.MatchDataSource
import com.test.core.remote.api.EquipeService
import com.test.core.remote.api.MatchService
import com.test.core.repository.EquipeRepository
import com.test.core.repository.MatchRepository
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
        .databaseBuilder(androidApplication(), AppDatabase::class.java, "OTV2.db")
        .build()
    }

    factory { get<AppDatabase>(DATABASE).matchDao() }
    factory { get<AppDatabase>(DATABASE).equipeDao() }

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

