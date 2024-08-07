package com.rushi.jettest.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rushi.jettest.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

// viewmodel/PostViewModel.kt
@HiltViewModel
class PostViewModel @Inject constructor(
    private val postRepository: PostRepository
) : ViewModel() {
    private val _state = MutableStateFlow(PostViewState())
    val state: StateFlow<PostViewState> = _state

    init {
        loadPosts()
    }

    private fun loadPosts() {
        viewModelScope.launch {
            postRepository.getPosts()
                .onStart {
                    _state.value = _state.value.copy(isLoading = true)
                    Log.d("PostViewModel", "Loading started")
                }
                .catch { e ->
                    _state.value = _state.value.copy(error = e.message, isLoading = false)
                    Log.e("PostViewModel", "Error: ${e.message}")
                }
                .collect { posts ->
                    _state.value = _state.value.copy(posts = posts, isLoading = false)
                    Log.d("PostViewModel", "Posts loaded: ${posts.size}")
                }
        }
    }


}


