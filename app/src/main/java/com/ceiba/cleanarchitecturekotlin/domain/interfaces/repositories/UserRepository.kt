package com.ceiba.cleanarchitecturekotlin.domain.interfaces.repositories

import com.ceiba.cleanarchitecturekotlin.domain.entities.UserDomain
import io.reactivex.Single

interface UserRepository {
    fun insert(user: UserDomain): Single<UserDomain?>
    fun insert(users: List<UserDomain>): Single<List<UserDomain>>
    fun select(): Single<List<UserDomain>>
    fun select(id: Int): Single<UserDomain?>
    fun select(ids: List<Int>): Single<List<UserDomain>>
    fun update(user: UserDomain): Single<UserDomain?>
    fun update(users: List<UserDomain>): Single<List<UserDomain>>
}