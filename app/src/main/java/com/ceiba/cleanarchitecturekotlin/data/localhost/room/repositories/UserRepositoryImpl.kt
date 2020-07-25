package com.ceiba.cleanarchitecturekotlin.data.localhost.room.repositories

import com.ceiba.cleanarchitecturekotlin.data.entities.UserEntity
import com.ceiba.cleanarchitecturekotlin.data.localhost.room.RoomConf
import com.ceiba.cleanarchitecturekotlin.data.localhost.room.dao.UserDao
import com.ceiba.cleanarchitecturekotlin.domain.entities.UserDomain
import com.ceiba.cleanarchitecturekotlin.domain.interfaces.repositories.UserRepository
import com.ceiba.cleanarchitecturekotlin.domain.tools.MapperObjects
import com.ceiba.cleanarchitecturekotlin.presentation.views.bases.BaseApplication
import io.reactivex.Single

class UserRepositoryImpl : UserRepository {

    private val userDao: UserDao = RoomConf.getDatabase(BaseApplication.getContext()).userDao()

    override fun insert(user: UserDomain): Single<UserDomain?> {
        val failedResponse: Single<UserDomain?> = Single.just(null)
        val userEntity = MapperObjects.toUserEntity(user) ?: return failedResponse
        return MapperObjects.toSubscribeSingleLong(userDao.insert(userEntity))
            .flatMap {
                val id = userEntity.id
                if (it != -1L) select(id) else failedResponse
            }
    }

    override fun insert(users: List<UserDomain>): Single<List<UserDomain>> {
        val usersEntity = MapperObjects.toUsersEntity(users)
        return MapperObjects.toSubscribeSingleLongs(userDao.insert(usersEntity))
            .map { list -> list.map { it.toInt() } }
            .flatMap { select(it) }
    }

    override fun select(): Single<List<UserDomain>> {
        return MapperObjects.toSubscribeSingleUsers(userDao.select())
            .map { MapperObjects.toUsersDomain(it) }
    }

    override fun select(id: Int): Single<UserDomain?> {
        return MapperObjects.toSubscribeSingleUser(userDao.select(id))
            .map { MapperObjects.toUserDomain(it) }
    }

    override fun select(ids: List<Int>): Single<List<UserDomain>> {
        return MapperObjects.toSubscribeSingleUsers(userDao.select(ids))
            .map { MapperObjects.toUsersDomain(it) }
    }

    override fun update(user: UserDomain): Single<UserDomain?> {
        val userEntity: UserEntity = MapperObjects.toUserEntity(user) ?: return Single.just(null)
        return MapperObjects.toSubscribeSingleInt(userDao.update(userEntity))
            .flatMap {
                val id = userEntity.id
                if (it != 0) select(id) else insert(user)
            }
    }

    override fun update(users: List<UserDomain>): Single<List<UserDomain>> {
        val usersEntity = MapperObjects.toUsersEntity(users)
        return MapperObjects.toSubscribeSingleInt(userDao.update(usersEntity))
            .flatMap {
                val ids = users.map { user -> user.id }
                if (it != 0) select(ids) else insert(users)
            }
    }
}