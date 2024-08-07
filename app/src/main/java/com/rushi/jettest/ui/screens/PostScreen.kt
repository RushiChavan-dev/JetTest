package com.rushi.jettest.ui.screens
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.rushi.jettest.ui.components.ErrorView
import com.rushi.jettest.ui.components.LoadingView
import com.rushi.jettest.ui.components.PostListView
import com.rushi.jettest.viewmodel.PostViewModel

// ui/screens/PostScreen.kt
@Composable
fun PostScreen(viewModel: PostViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()

    when {
        state.isLoading -> LoadingView()
        state.error != null -> ErrorView(state.error)
        else -> PostListView(state.posts)
    }
}
