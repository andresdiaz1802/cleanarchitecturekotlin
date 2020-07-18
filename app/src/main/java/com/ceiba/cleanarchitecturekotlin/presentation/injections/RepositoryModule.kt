package com.ceiba.cleanarchitecturekotlin.presentation.injections

import com.ceiba.cleanarchitecturekotlin.data.api.repositories.UserRepositoryImpl
import com.ceiba.cleanarchitecturekotlin.domain.interfaces.repositories.UserRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun instanceUserRepositoryImpl(): UserRepository = UserRepositoryImpl()
}