package com.ceiba.cleanarchitecturekotlin.data.api.entities

import java.io.Serializable

data class UserEntity(
    val name: String,
    val email: String,
    val phone:String
) : Serializable