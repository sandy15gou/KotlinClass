package com.example.exploringkotlinclasses

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.PI

// Circle
// Data: radius
// Functions/Methods/Behaviors
// set radius
// get radius
// circumference
// area
// diameter
class Circle(private var radius: Double) {
    fun setRadius(newRadius: Double) {
        if (newRadius < 0) {
            print("Radius must be positive")
        } else {
            radius = newRadius
        }
    }

    fun getRadius() = radius

    fun circumference() = 2 * PI * radius

    // Exercise: Please implement area and diameter methods
    fun area() = PI * radius * radius

    fun diameter() = 2 * radius
}

@Composable
fun CirclePropertiesScreen() {
    // State drives everything — Circle is updated from state
    var radius by remember { mutableDoubleStateOf(3.5) }
    val circle = remember { Circle(radius = radius) }

    // Sync circle model with slider radius state
    circle.setRadius(radius)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Circle Properties", style = MaterialTheme.typography.headlineMedium)
        Text("Radius: ${circle.getRadius()}")
        Text("Diameter: ${circle.diameter()}")
        Text("Circumference: ${circle.circumference()}")
        Text("Area: ${circle.area()}")

        // Slider to update the radius
        Slider(
            value = radius.toFloat(),
            onValueChange = { radius = it.toDouble() },
            valueRange = 1f..100f
        )

        // Create Circle Shape using a Box...
        Spacer(Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .size(circle.diameter().dp)
                .background(Color.Blue, shape = CircleShape)
                .align(Alignment.CenterHorizontally)
        )
    }
}


@Preview
@Composable
private fun ClassDemoPreview() {
    CirclePropertiesScreen()
}