package com.example.exploringkotlinclasses

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.util.UUID

data class Product(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val price: Double,
    val inStock: Boolean
) {
    override fun toString() = "$name - \$$price (${if (inStock) "In stock" else "Out of Stock"})"
}

@Composable
fun ProductListScreen() {
    val product1 = Product(name = "Wireless Mouse", price = 29.99, inStock = true)
    val product2 = Product(name = "Mechanical Keyboard", price = 89.99, inStock = false)
    val product3 = Product(name = "USB-C Cable", price = 9.99, inStock = true)
    val product4 = product2.copy(price = 39.99, inStock = true)

    val products = listOf(
        product1,
        product2,
        product3,
        product4
    )

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        items(products) { product ->
            // componentN - gives us destructuring for free
            val (id, name, price, inStock) = product

            Text("$product") // Using toString

            Spacer(Modifier.height(12.dp))
        }
    }
}

@Preview
@Composable
private fun ProductListScreenPreview() {
    ProductListScreen()
}