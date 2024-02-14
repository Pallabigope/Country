package com.example.mapcountryzip.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mapcountryzip.database.AppDatabase
import com.example.mapcountryzip.network.ApiServiceFactory
import com.example.mapcountryzip.repository.DataRepository
import com.example.mapcountryzip.viewmodel.SecondScreenViewModel

class MainActivity : ComponentActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val database = AppDatabase.getDatabase(this)
            val repository = DataRepository(database.dataDao())
            val secondScreenViewModel = remember { SecondScreenViewModel(ApiServiceFactory.create(), repository) }

            NavHost(navController = navController, startDestination = Screen.FirstScreen.route) {
                composable(route = Screen.FirstScreen.route) {
                    FirstScreen(navController)
                }
                composable(route = Screen.SecondScreen.route +"/{countryCode}/{postalCodeRange}",
                arguments = listOf(navArgument("countrtycode"){
                    type= NavType.StringType
                    defaultValue="US"
                },
                    navArgument("postalCodeRange") {
                        type = NavType.StringType
                        defaultValue = "00000-0000"
                    })
                ) {
                    entry->
                    val countryCode = entry.arguments?.getString("countryCode") ?: ""
                    val postalCodeRange = entry.arguments?.getString("postalCodeRange") ?: ""
                    SecondScreen(navController = navController,
                        secondScreenViewModel = secondScreenViewModel,
                        countryCode=countryCode,
                        postalCodeRange=postalCodeRange)
                }
                composable("third_screen_route") {

                    ThirdScreen(viewModel = viewModel())
                }

                }
            }
        }
    }



