package com.ceiba.cleanarchitecturekotlin.presentation.interfaces

import androidx.lifecycle.LiveData

interface UserViewModel {
    fun getUsers()
    fun getUsersLiveData(): LiveData<Any>
}