package com.ceiba.cleanarchitecturekotlin.data.api.retrofit

import com.ceiba.cleanarchitecturekotlin.data.Constants.Companion.HOSTNAME
import com.ceiba.cleanarchitecturekotlin.data.api.retrofit.dao.UserDao
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConf {

    companion object {

        private var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(HOSTNAME)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        fun people(): UserDao = retrofit.create(UserDao::class.java)
    }
}