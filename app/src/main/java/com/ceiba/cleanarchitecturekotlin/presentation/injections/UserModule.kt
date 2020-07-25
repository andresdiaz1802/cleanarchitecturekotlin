package com.ceiba.cleanarchitecturekotlin.presentation.injections

import com.ceiba.cleanarchitecturekotlin.domain.interfaces.repositories.UserRepository
import com.ceiba.cleanarchitecturekotlin.domain.interfaces.services.UserService
import com.ceiba.cleanarchitecturekotlin.domain.services.UserServiceImpl
import com.ceiba.cleanarchitecturekotlin.presentation.Constants
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class UserModule {

    @Provides
    fun instanceUserServiceImpl(
        @Named(Constants.USER_REPOSITORY_API_NAME) userRepositoryApi: UserRepository,
        @Named(Constants.USER_REPOSITORY_LOCAL_NAME) userRepositoryLocal: UserRepository
    ): UserService = UserServiceImpl(userRepositoryApi, userRepositoryLocal)
}