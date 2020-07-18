package com.ceiba.cleanarchitecturekotlin.presentation.viewmodel.activities

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ceiba.cleanarchitecturekotlin.domain.interfaces.services.UserService
import com.ceiba.cleanarchitecturekotlin.presentation.interfaces.UserViewModel
import com.ceiba.cleanarchitecturekotlin.presentation.views.bases.BaseApplication
import javax.inject.Inject

class UserViewModelImpl : ViewModel(), UserViewModel {

    @set:Inject
    lateinit var userService: UserService

    private val users: MutableLiveData<Any> = MutableLiveData<Any>()

    init {
        BaseApplication.getApplicationComponent()?.inject(this)
    }

    @SuppressLint("CheckResult")
    override fun getUsers() {
        userService.consultUsers().subscribe(
            { users.value = it },
            { Log.d("tag_message", it.message ?: "This is error") }
        )
    }

    override fun getUsersLiveData(): LiveData<Any> = users


}