package com.ceiba.cleanarchitecturekotlin.presentation.views.bases

import android.app.Application
import com.ceiba.cleanarchitecturekotlin.presentation.injections.ApplicationComponent
import com.ceiba.cleanarchitecturekotlin.presentation.injections.DaggerApplicationComponent
import com.ceiba.cleanarchitecturekotlin.presentation.injections.RepositoryModule
import com.ceiba.cleanarchitecturekotlin.presentation.injections.UserModule

class BaseApplication : Application() {
    init {
        instance = this
        applicationComponent = DaggerApplicationComponent.builder()
            .repositoryModule(RepositoryModule())
            .build()
    }

    companion object {
        private var instance: BaseApplication? = null
        private var applicationComponent: ApplicationComponent? = null
        fun getContext() = instance!!.applicationContext
        fun getApplicationComponent(): ApplicationComponent? = applicationComponent
    }
}