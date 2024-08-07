package com.rushi.jettest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rushi.jettest.model.room_model.PostDao
import com.rushi.jettest.network.ApiServices
import com.rushi.jettest.repository.PostRepository
import com.rushi.jettest.ui.screens.PostScreen
import com.rushi.jettest.ui.theme.JetTestTheme
import com.rushi.jettest.viewmodel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetTestTheme {
                PostScreen()
            }
        }
    }
}