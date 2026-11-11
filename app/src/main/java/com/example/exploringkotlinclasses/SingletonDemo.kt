package com.example.exploringkotlinclasses

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

object CounterManager {
    // Singleton keeps a global counter
    var count = 0
    fun increment() { count++ }
}

@Composable
fun CounterScreen() {
    var counter by remember {
        mutableStateOf(CounterManager.count)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Counter: $counter",
            style = MaterialTheme.typography.headlineMedium
        )

        Button(
            onClick = {
                CounterManager.increment()
                counter = CounterManager.count
            }
        ) {
            Text("Increment")
        }
    }
}

@Preview
@Composable
private fun CounterScreenPreview() {
    CounterScreen()
}
