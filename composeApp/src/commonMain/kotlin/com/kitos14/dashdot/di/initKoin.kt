package com.kitos14.dashdot.di

import authenticationFeatureModule
import createStepFeatureModule
import createTaskFeatureModule
import homeFeatureModule
import org.koin.core.annotation.KoinInternalApi
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import taskRepositoryModule
import taskUseCaseModule
import taskViewFeatureModule
import tasksFeatureModule

@OptIn(KoinInternalApi::class)
fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            mainModule,

            // Repositories
            taskRepositoryModule,

            // UseCases
            taskUseCaseModule,

            // Features
            authenticationFeatureModule,
            createStepFeatureModule,
            createTaskFeatureModule,
            homeFeatureModule,
            tasksFeatureModule,
            taskViewFeatureModule,
        )
    }
}