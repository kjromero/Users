package com.kenny.users.entities.interfaces

import com.kenny.users.entities.data.User
import io.reactivex.rxjava3.core.Single

interface UsersRepository {

    fun getUsers(): Single<List<User>>

}