package com.rushi.jettest.repository

import com.rushi.jettest.model.Post
import com.rushi.jettest.model.room_model.PostDao
import com.rushi.jettest.network.ApiServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

import javax.inject.Inject

// repository/PostRepository.kt
class PostRepository @Inject constructor(
    private val apiService: ApiServices,
    private val postDao: PostDao
) {
    fun getPosts(): Flow<List<Post>> = flow {
        // Emit cached data first
        emit(postDao.getAllPost().first())

        // Fetch posts from the network
        val posts = apiService.getPosts()

        // Insert the fetched posts into the database
        postDao.insertPost(posts)

        // Emit updated data from the database
        emitAll(postDao.getAllPost())
    }.flowOn(Dispatchers.IO) // Ensure the flow runs on the IO dispatcher
}