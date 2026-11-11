package com.example.exploringkotlinclasses

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

enum class Direction(
    val title: String,
    val color: Color
) {
    NORTH("North", Color(0xFF0B80E1)),
    SOUTH("South", Color(0xFFE50B21)),
    EAST("East",  Color(0xFF0EC415)),
    WEST("West",  Color(0xFFD3C017))
}

@Composable
fun DirectionDemo() {
    var current by remember { mutableStateOf(Direction.NORTH) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "Current: ${current.title}",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(Modifier.height(24.dp))

        Direction.values().forEach { direction ->
            Button(
                onClick = { current = direction },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = direction.color,
                    contentColor = Color.Black
                )
            ) {
                Text(
                    direction.title
                )
            }
        }
    }
}

@Preview
@Composable
private fun DirectionDemoPreview() {
    DirectionDemo()
}