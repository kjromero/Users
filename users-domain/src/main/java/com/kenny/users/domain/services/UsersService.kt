package com.kenny.users.domain.services

import com.kenny.users.domain.services.model.UserResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface UsersService {

    @GET("users")
    fun getRepositories(): Single<List<UserResponse>>
}