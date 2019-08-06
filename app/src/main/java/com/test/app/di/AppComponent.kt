package com.test.app.di

import com.test.core.di.createRemoteModule
import com.test.core.di.localModule
import com.test.core.di.repositoryModule
import com.test.equipe.di.equipeModule
import com.test.match.di.matchModule

val appComponent = listOf(
    createRemoteModule("https://api.wfootball.eu/"),
    repositoryModule,
    localModule,
    appModule,
    matchModule,
    equipeModule
)