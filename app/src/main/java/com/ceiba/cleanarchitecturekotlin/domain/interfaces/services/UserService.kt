package com.ceiba.cleanarchitecturekotlin.domain.interfaces.services

import com.ceiba.cleanarchitecturekotlin.domain.entities.UserDomain
import io.reactivex.Single

interface UserService {
    fun consultUser(id: Int): Single<UserDomain?>
    fun consultUsers(): Single<List<UserDomain>?>
}