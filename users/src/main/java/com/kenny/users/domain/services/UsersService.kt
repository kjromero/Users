package com.kenny.users.domain.services

import com.kenny.users.domain.services.model.PostsResponse
import com.kenny.users.domain.services.model.UserResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersService {

    @GET("users")
    fun getRepositories(): Single<List<UserResponse>>

    @GET("posts")
    fun getPosts(@Query("userId") userId: Int): Single<List<PostsResponse>>
}