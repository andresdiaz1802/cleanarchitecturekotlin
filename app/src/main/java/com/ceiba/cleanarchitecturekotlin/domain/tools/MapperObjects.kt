package com.ceiba.cleanarchitecturekotlin.domain.tools

import com.ceiba.cleanarchitecturekotlin.data.api.entities.UserEntity
import com.ceiba.cleanarchitecturekotlin.domain.entities.UserDomain
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MapperObjects {

    companion object {

        private val gson: Gson = Gson()

        fun toSerializer(any: Any?): String? = if (any == null) any else gson.toJson(any)

        fun toSubscribeSingles(single: Single<UserEntity?>) = single
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

        fun toSubscribeSingle(single: Single<List<UserEntity>>) = single
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())


        // Domain

        fun toUserDomain(user: UserEntity?): UserDomain? {
            val serializer = toSerializer(user)
            return if (serializer.isNullOrBlank()) null
            else gson.fromJson(serializer, UserDomain::class.java)
        }

        fun toUsersDomain(users: List<UserEntity>): List<UserDomain> {
            val serializer = toSerializer(users)
            val type = object : TypeToken<List<UserDomain>>() {}.type
            return gson.fromJson(serializer, type)
        }

    }
}