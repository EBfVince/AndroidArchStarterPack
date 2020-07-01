package com.ebfstudio.footballeuse.di

import androidx.room.Room
import com.ebfstudio.footballeuse.data.local.AppDatabase
import com.ebfstudio.footballeuse.data.local.DatabaseMigrations
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * Created by Vincent Guillebaud on 01/07/2020
 */

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

}