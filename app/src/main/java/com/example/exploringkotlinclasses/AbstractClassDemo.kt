package com.example.exploringkotlinclasses

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.stylusHoverIcon
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

abstract class Shape {
    abstract fun area(): Double
    abstract fun perimeter(): Double
    abstract fun name(): String

    fun description() = "I am a ${name()} shape with area " +
            "${"%.2f".format(area())} " +
                "and perimeter ${"%.2f".format(perimeter())}."
}

class MyCircle(
    var radius: Double
) : Shape() {
    override fun area() = Math.PI * radius * radius
    override fun perimeter() = 2 * Math.PI * radius

    override fun name() = "Circle"
}

@Composable
fun CircleDemoScreen() {
    var circle = remember {
        MyCircle(radius = 80.0)
    }

    var text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = circle.description(),
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Box(
            modifier = Modifier
                .size(circle.radius.dp)
                .shadow(8.dp, CircleShape)
                .clip(CircleShape)
                .background(
                    Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF42A5F5),
                            Color(0xFF47E04A)
                        )
                    )
                )
                .border(2.dp, Color(0xFF0B41E5), CircleShape)
        )


        TextField(
            value = text,
            onValueChange = { input ->
                text = input
                // If input is valid then update circle.radius
                input.toDoubleOrNull()?.let {
                    circle.radius = it
                }
            },
            modifier = Modifier
                .fillMaxWidth()
        )
    }


}

@Preview
@Composable
private fun CircleDemoScreenPreview() {
    CircleDemoScreen()
}

