package com.ceiba.cleanarchitecturekotlin.data.localhost.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ceiba.cleanarchitecturekotlin.data.Constants.Companion.NAME_DATABASE
import com.ceiba.cleanarchitecturekotlin.data.entities.UserEntity
import com.ceiba.cleanarchitecturekotlin.data.localhost.room.dao.UserDao

@Database(
    entities = [UserEntity::class],
    version = 1,
    exportSchema = false
)
abstract class RoomConf : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: RoomConf? = null

        fun getDatabase(context: Context): RoomConf {
            val temInstance = INSTANCE
            if (temInstance != null) return temInstance
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, RoomConf::class.java, NAME_DATABASE
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                return INSTANCE as RoomConf
            }
        }
    }
}