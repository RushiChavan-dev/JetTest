package com.rushi.jettest.viewmodel

import com.rushi.jettest.model.Post

data class PostViewState(
    val posts: List<Post> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)