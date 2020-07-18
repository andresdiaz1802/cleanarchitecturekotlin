package com.ceiba.cleanarchitecturekotlin.presentation.injections

import com.ceiba.cleanarchitecturekotlin.domain.interfaces.repositories.UserRepository
import com.ceiba.cleanarchitecturekotlin.domain.interfaces.services.UserService
import com.ceiba.cleanarchitecturekotlin.domain.services.UserServiceImpl
import dagger.Module
import dagger.Provides

@Module
class UserModule {

    @Provides
    fun instanceUserServiceImpl(userRepository: UserRepository): UserService =
        UserServiceImpl(userRepository)
}