package com.example.mapcountryzip.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.livedata.observeAsState
import com.example.mapcountryzip.viewmodel.DataViewModel


@Composable
fun ThirdScreen(viewModel: DataViewModel = viewModel()) {
    val cartItems by viewModel.cartItems.observeAsState()

    LazyColumn(
        modifier = Modifier.padding(16.dp),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(cartItems ?: emptyList()) { dataWithPlaces ->
            Column(
                modifier = Modifier.padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Country: ${dataWithPlaces.data.country}")
                dataWithPlaces.places.forEach { place ->
                    Text(text = "Place: ${place.placename}")
                }
            }
        }
    }
}
