package com.test.app.di

import com.adelya.otv2.core.di.createRemoteModule
import com.adelya.otv2.core.di.localModule
import com.adelya.otv2.core.di.repositoryModule
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