package com.ceiba.cleanarchitecturekotlin.domain.entities

data class UserDomain(
    val id: Int,
    val name: String,
    val email: String,
    val phone: String
)