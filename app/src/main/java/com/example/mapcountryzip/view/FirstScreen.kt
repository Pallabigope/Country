package com.example.mapcountryzip.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.FlowRowScopeInstance.align
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mapcountryzip.R



@Composable
fun FirstScreen(
    navController: NavController
) {
    var countryCode by remember { mutableStateOf("") }
    var postalCodeRange by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Background image
        Image(
            painter = painterResource(id = R.drawable.acorns),
            contentDescription = null, // provide a meaningful description
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            // Country Code Input
            OutlinedTextField(
                value = countryCode,
                onValueChange = { countryCode = it },
                label = { Text("Country Code") }
            )
            Spacer(
                modifier = Modifier
                    .height(16.dp)
            )
            // Postal Code Input
            OutlinedTextField(
                value = postalCodeRange,
                onValueChange = { postalCodeRange = it },
                label = { Text("Postal Code Range") }
            )
            Spacer(
                modifier = Modifier
                    .height(16.dp)
            )
            // Submit Button
            Button(
                onClick = {
                    // Validate input and navigate to second screen
                    if (validateInput(countryCode, postalCodeRange)) {

                        navController.navigate(
                            Screen.SecondScreen.withArgs(
                                countryCode,
                                postalCodeRange
                            )
                        )
                    }
                }
            ) {
                Text(text = "Submit")
            }
        }
    }
}

// Function to validate input data
private fun validateInput(countryCode: String, postalCodeRange: String): Boolean {

    return countryCode.isNotEmpty() && postalCodeRange.isNotEmpty()
}

