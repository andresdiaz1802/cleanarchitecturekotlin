package com.ceiba.cleanarchitecturekotlin.data.localhost.room.dao

import androidx.room.*
import com.ceiba.cleanarchitecturekotlin.data.Constants.Companion.TABLE_USER
import com.ceiba.cleanarchitecturekotlin.data.entities.UserEntity
import io.reactivex.Single

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user: UserEntity): Single<Long>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(users: List<UserEntity>): Single<List<Long>>

    @Query("SELECT * FROM $TABLE_USER")
    fun select(): Single<List<UserEntity>>

    @Query("SELECT * FROM $TABLE_USER WHERE id=:id")
    fun select(id: Int): Single<UserEntity?>

    @Query("SELECT * FROM $TABLE_USER WHERE id in (:ids)")
    fun select(ids: List<Int>): Single<List<UserEntity>>

    @Update
    fun update(vararg user: UserEntity): Single<Int>

    @Update
    fun update(users: List<UserEntity>): Single<Int>
}