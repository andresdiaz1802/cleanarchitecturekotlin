package com.ceiba.cleanarchitecturekotlin.data.entities

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ceiba.cleanarchitecturekotlin.data.Constants
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = Constants.TABLE_USER)
data class UserEntity(
    @PrimaryKey @ColumnInfo(name = Constants.ID)
    @SerializedName(Constants.ID) @Expose @Keep val id: Int,
    @ColumnInfo(name = Constants.NAME)
    @SerializedName(Constants.NAME) @Expose @Keep val name: String,
    @ColumnInfo(name = Constants.EMAIL)
    @SerializedName(Constants.EMAIL) @Expose @Keep val email: String,
    @ColumnInfo(name = Constants.PHONE)
    @SerializedName(Constants.PHONE) @Expose @Keep val phone: String
) : Serializable