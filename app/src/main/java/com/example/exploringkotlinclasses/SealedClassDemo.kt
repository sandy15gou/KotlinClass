package com.example.exploringkotlinclasses

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

sealed class MyScreenState {
    object Loading : MyScreenState()

    data class Success(val message: String): MyScreenState()
    data class Error(val message: String): MyScreenState()
}

class MyViewModel {
    var state by mutableStateOf<MyScreenState>(MyScreenState.Loading)
        private set

    fun load() {
        state = MyScreenState.Success("Data loaded successfully!")
    }

    fun fail() {
        state = MyScreenState.Error("Something went wrong.")
    }
}

@Composable
fun SealedClassDemoScreen() {
    val viewModel = remember { MyViewModel() }

    LaunchedEffect(Unit) {
        delay(2000)
        viewModel.load()
    }

    // Current state
    val state = viewModel.state
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        // Handle possible UI States
        when(state) {
            is MyScreenState.Loading -> {
                CircularProgressIndicator()
            }
            is MyScreenState.Success -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = state.message,
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color(0xFF11D91E)
                    )
                    Spacer(Modifier.height(16.dp))
                    Button(
                        onClick = { viewModel.fail() }
                    ) {
                        Text("Simulate Error")
                    }
                }
            }
            is MyScreenState.Error -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = state.message,
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color(0xFFC21A0E)
                    )
                    Spacer(Modifier.height(16.dp))
                    Button(
                        onClick = { viewModel.load() }
                    ) {
                        Text("Retry")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun SealedClassDemoScreenPreview() {
    SealedClassDemoScreen()
}