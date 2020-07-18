package com.ceiba.cleanarchitecturekotlin.domain.interfaces.repositories

import com.ceiba.cleanarchitecturekotlin.domain.entities.UserDomain
import io.reactivex.Single

interface UserRepository {
    fun select(): Single<List<UserDomain>>
    fun select(id: Int): Single<UserDomain?>
}