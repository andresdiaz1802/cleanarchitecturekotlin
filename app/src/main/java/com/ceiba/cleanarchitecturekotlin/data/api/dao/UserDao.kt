package com.ceiba.cleanarchitecturekotlin.data.api.dao

import com.ceiba.cleanarchitecturekotlin.data.Constants.Companion.ID
import com.ceiba.cleanarchitecturekotlin.data.Constants.Companion.USERS
import com.ceiba.cleanarchitecturekotlin.data.api.entities.UserEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface UserDao {
    @GET(USERS)
    fun select(): Single<List<UserEntity>>

    @GET("$USERS/{$ID}")
    fun select(@Path(ID) id: Int): Single<UserEntity?>
}