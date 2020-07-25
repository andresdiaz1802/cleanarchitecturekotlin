package com.ceiba.cleanarchitecturekotlin.domain.services

import com.ceiba.cleanarchitecturekotlin.domain.entities.UserDomain
import com.ceiba.cleanarchitecturekotlin.domain.interfaces.repositories.UserRepository
import com.ceiba.cleanarchitecturekotlin.domain.interfaces.services.UserService
import io.reactivex.Single

class UserServiceImpl(
    private val userRepositoryApi: UserRepository,
    private val userRepositoryLocal: UserRepository
) : UserService {

    override fun consultUser(id: Int): Single<UserDomain?> = userRepositoryApi.select(id)

    override fun consultUsers(): Single<List<UserDomain>?> = userRepositoryLocal.select()
        .flatMap { users -> if (users.isEmpty()) userRepositoryApi.select() else Single.just(users) }
        .flatMap { users -> userRepositoryLocal.update(users) }
        .map { users -> if (users.isEmpty()) null else users }
}