package com.example.exploringkotlinclasses

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class NetworkResponse(
    val message: String?,
    val status: Status
) {

    sealed class Status {
        object Success : Status()
        object Error : Status()
        object Loading : Status()
    }
}

@Composable
fun NetworkApp() {
    var response by remember {
        mutableStateOf(
            NetworkResponse(
                "Loading data...",
                NetworkResponse.Status.Loading)
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = when(response.status) {
                NetworkResponse.Status.Success -> "Success: ${response.message}"
                NetworkResponse.Status.Error -> "Failure: ${response.message}"
                NetworkResponse.Status.Loading -> "Loading..."
            }
        )

        Spacer(Modifier.height(32.dp))

        Button(
            onClick = {
                response = NetworkResponse("Data loaded!", NetworkResponse.Status.Success)
            }
        ) {
            Text("Success")
        }

        Spacer(Modifier.height(12.dp))
        Button(
            onClick = {
                response = NetworkResponse("Something went wrong!", NetworkResponse.Status.Error)
            }
        ) {
            Text("Error")
        }

        Spacer(Modifier.height(12.dp))

        Button(
            onClick = {
                response = NetworkResponse(null, NetworkResponse.Status.Loading)
            }
        ) {
            Text("Loading")
        }
    }
}

@Preview
@Composable
private fun NetworkAppPreview() {
    NetworkApp()
}