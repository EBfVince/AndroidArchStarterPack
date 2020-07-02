package com.ebfstudio.footballeuse.di

import androidx.room.Room
import com.ebfstudio.footballeuse.data.local.AppDatabase
import com.ebfstudio.footballeuse.data.local.DatabaseMigrations
import com.ebfstudio.footballeuse.data.remote.api.FoodiumService
import com.ebfstudio.footballeuse.data.repository.ArticleRepository
import com.ebfstudio.footballeuse.ui.notifications.NotificationsViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by Vincent Guillebaud on 01/07/2020
 */

@ExperimentalCoroutinesApi
val appModule = module {

    single {
        Room
            .databaseBuilder(androidContext(), AppDatabase::class.java, "molo.vince")
            .addMigrations(
                DatabaseMigrations.MIGRATION_1_2,
                DatabaseMigrations.MIGRATION_2_3,
                DatabaseMigrations.MIGRATION_3_4,
                DatabaseMigrations.MIGRATION_4_5
            )
            .build()
    }

    factory { get<AppDatabase>().articleDao() }


    single {

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        Retrofit.Builder()
            .baseUrl(FoodiumService.FOODIUM_API_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    }

    factory { get<Retrofit>().create(FoodiumService::class.java) }

    viewModel { NotificationsViewModel(get()) }

    factory { ArticleRepository(get(), get()) }

}