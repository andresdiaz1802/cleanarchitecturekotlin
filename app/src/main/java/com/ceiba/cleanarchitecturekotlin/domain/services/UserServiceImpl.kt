package com.ceiba.cleanarchitecturekotlin.domain.services

import com.ceiba.cleanarchitecturekotlin.domain.entities.UserDomain
import com.ceiba.cleanarchitecturekotlin.domain.interfaces.repositories.UserRepository
import com.ceiba.cleanarchitecturekotlin.domain.interfaces.services.UserService
import io.reactivex.Single

class UserServiceImpl(private val userRepository: UserRepository) : UserService {

    override fun consultUser(id: Int): Single<UserDomain?> = userRepository.select(id)

    override fun consultUsers(): Single<Any> = userRepository.select()
        .map { users -> if (users.isEmpty()) null else users }
}