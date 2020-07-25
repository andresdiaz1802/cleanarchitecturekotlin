package com.ceiba.cleanarchitecturekotlin.data.api.retrofit.repositories

import com.ceiba.cleanarchitecturekotlin.data.api.retrofit.RetrofitConf
import com.ceiba.cleanarchitecturekotlin.data.api.retrofit.dao.UserDao
import com.ceiba.cleanarchitecturekotlin.domain.entities.UserDomain
import com.ceiba.cleanarchitecturekotlin.domain.interfaces.repositories.UserRepository
import com.ceiba.cleanarchitecturekotlin.domain.tools.MapperObjects
import io.reactivex.Single

class UserRepositoryImpl : UserRepository {

    private val userDao: UserDao = RetrofitConf.people()

    override fun insert(user: UserDomain): Single<UserDomain?> {
        TODO("Not yet implemented")
    }

    override fun insert(users: List<UserDomain>): Single<List<UserDomain>> {
        TODO("Not yet implemented")
    }

    override fun select(): Single<List<UserDomain>> =
        MapperObjects.toSubscribeSingleUsers(userDao.select())
            .map { MapperObjects.toUsersDomain(it) }

    override fun select(id: Int): Single<UserDomain?> =
        MapperObjects.toSubscribeSingleUser(userDao.select(id))
            .map { MapperObjects.toUserDomain(it) }

    override fun select(ids: List<Int>): Single<List<UserDomain>> {
        TODO("Not yet implemented")
    }

    override fun update(user: UserDomain): Single<UserDomain?> {
        TODO("Not yet implemented")
    }

    override fun update(users: List<UserDomain>): Single<List<UserDomain>> {
        TODO("Not yet implemented")
    }
}