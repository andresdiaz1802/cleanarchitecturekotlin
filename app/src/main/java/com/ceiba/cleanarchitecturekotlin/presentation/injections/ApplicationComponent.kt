package com.ceiba.cleanarchitecturekotlin.presentation.injections

import com.ceiba.cleanarchitecturekotlin.presentation.viewmodel.activities.UserViewModelImpl
import dagger.Component

@Component(modules = [RepositoryModule::class, UserModule::class])
interface ApplicationComponent {
    fun inject(UserViewModel: UserViewModelImpl)
}