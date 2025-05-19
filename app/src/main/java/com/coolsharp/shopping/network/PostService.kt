package com.coolsharp.shopping.network

import com.coolsharp.shopping.data.Posts
import retrofit2.Response
import retrofit2.http.GET

interface PostService {
    @GET("/posts")
    suspend fun getPostList(
    ): Response<Posts>
}