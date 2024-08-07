package com.rushi.jettest.network

import com.rushi.jettest.model.Post
import retrofit2.http.GET

interface ApiServices {
    @GET("/posts")
    suspend fun getPosts(): List<Post>
}