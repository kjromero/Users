package com.kenny.users.entities.data

import java.io.Serializable

data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
): Serializable

data class Address(
    val street: String,
    val suite: String,
    val city: String,
): Serializable