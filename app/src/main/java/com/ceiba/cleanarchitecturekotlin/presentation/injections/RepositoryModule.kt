package com.ceiba.cleanarchitecturekotlin.presentation.injections

import com.ceiba.cleanarchitecturekotlin.domain.interfaces.repositories.UserRepository
import com.ceiba.cleanarchitecturekotlin.presentation.Constants
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class RepositoryModule {

    @Provides
    @Named(Constants.USER_REPOSITORY_API_NAME)
    fun instanceUserRepositoryApiImpl(): UserRepository =
        com.ceiba.cleanarchitecturekotlin.data.api.retrofit.repositories.UserRepositoryImpl()

    @Provides
    @Named(Constants.USER_REPOSITORY_LOCAL_NAME)
    fun instanceUserRepositoryLocalImpl(): UserRepository =
        com.ceiba.cleanarchitecturekotlin.data.localhost.room.repositories.UserRepositoryImpl()
}