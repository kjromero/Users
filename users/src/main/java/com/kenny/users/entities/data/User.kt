package com.kenny.users.entities.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "users")
data class User(
    @PrimaryKey
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
//    val address: Address,
    val phone: String,
): Serializable

data class Address(
    val street: String,
    val suite: String,
    val city: String,
): Serializable