package com.ceiba.cleanarchitecturekotlin.data.api.repositories

import com.ceiba.cleanarchitecturekotlin.data.api.RetrofitConf
import com.ceiba.cleanarchitecturekotlin.data.api.dao.UserDao
import com.ceiba.cleanarchitecturekotlin.domain.entities.UserDomain
import com.ceiba.cleanarchitecturekotlin.domain.interfaces.repositories.UserRepository
import com.ceiba.cleanarchitecturekotlin.domain.tools.MapperObjects
import io.reactivex.Single

class UserRepositoryImpl : UserRepository {

    private val userDao: UserDao = RetrofitConf.people()

    override fun select(): Single<List<UserDomain>> =
        MapperObjects.toSubscribeSingle(userDao.select())
            .map { MapperObjects.toUsersDomain(it) }

    override fun select(id: Int): Single<UserDomain?> =
        MapperObjects.toSubscribeSingles(userDao.select(id))
            .map { MapperObjects.toUserDomain(it) }
}