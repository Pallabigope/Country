package com.example.mapcountryzip.view

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mapcountryzip.viewmodel.SecondScreenViewModel


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("SuspiciousIndentation")
@Composable
fun SecondScreen(
    navController: NavController,
    secondScreenViewModel: SecondScreenViewModel,
    countryCode: String,
    postalCodeRange: String
) {
    val responseData by secondScreenViewModel.responseData.observeAsState()

    LaunchedEffect(Unit) {

        secondScreenViewModel.fetchData(countryCode, postalCodeRange)

    }
    LazyColumn {
        item {
            TopAppBar(
                title = {
                    Text(
                        text = "Country",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(imageVector = Icons.Filled.Search, contentDescription = null)
                    }
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                },
                modifier = Modifier

            )
        }

        item {
            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                // .wrapContentSize(Alignment.Center),
                shape = RoundedCornerShape(8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                        //.height(1000.dp),
                    contentAlignment = Alignment.Center
                )
                {
                    Column(
                        modifier = Modifier,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {


                        // Display the data when available
                        responseData?.let { response ->
                            if (response.isSuccessful) {
                                val data = response.body()
                                // Update UI with fetched data
                                if (data != null) {
                                    Text(text = "Country: ${data.country}")
                                    Spacer(modifier = Modifier.size(10.dp))
                                    Text(text = "Country Abbreviation: ${data.countryabbreviation}")
                                    Spacer(modifier = Modifier.size(8.dp))
                                    data.places.forEach { place ->
                                        Text(text = "Place Name: ${place.placename}")
                                        Spacer(modifier = Modifier.size(8.dp))
                                        Text(text = "Latitude: ${place.latitude}")
                                        Spacer(modifier = Modifier.size(8.dp))
                                        Text(text = "Longitude: ${place.longitude}")
                                        Spacer(modifier = Modifier.size(8.dp))
                                        Text(text = "State: ${place.state}")
                                    }

                                    Button(
                                        onClick = {
                                            val places = data?.places ?: emptyList()
                                            secondScreenViewModel.saveToDatabase(data, places)
                                        },
                                        modifier = Modifier.padding(vertical = 16.dp)
                                    ) {
                                        Text("Add to Bookmark")
                                    }

                                    Button(
                                        onClick = {
                                            navController.navigate("third_screen_route")
                                        },
                                        modifier = Modifier.padding(vertical = 16.dp)
                                    ) {
                                        Text("View Bookmark")
                                    }

                                } else {
                                    Text(text = "Error: No data available")
                                }

                            } else {
                                // Handle API error
                                Text(text = "Error: Unable to fetch data from the API")
                            }
                        }
                    }
                }
            }

        }
    }
}