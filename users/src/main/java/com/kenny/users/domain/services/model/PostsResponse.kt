package com.kenny.users.domain.services.model

import com.google.gson.annotations.SerializedName

data class PostsResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("userId") val userId: Int,
    @SerializedName("title") val title: String,
    @SerializedName("body") val body: String,
)
