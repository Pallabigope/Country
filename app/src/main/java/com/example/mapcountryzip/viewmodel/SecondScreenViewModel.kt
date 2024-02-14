package com.example.mapcountryzip.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mapcountryzip.data.Data
import com.example.mapcountryzip.data.Place
import com.example.mapcountryzip.database.DataEntity
import com.example.mapcountryzip.database.PlaceEntity
import com.example.mapcountryzip.network.ApiService
import com.example.mapcountryzip.repository.DataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class SecondScreenViewModel(private val apiService: ApiService,
                            private val repository: DataRepository
) : ViewModel() {

    private val _responseData = MutableLiveData<Response<Data>>()
    val responseData: LiveData<Response<Data>> = _responseData

    fun fetchData(countryCode: String, postalCodeRange: String) {
        val url = "https://api.zippopotam.us/$countryCode/$postalCodeRange"
        Log.d("API_REQUEST","Fetching data from URL:$url")
        viewModelScope.launch {
            try {
                // Making API call using Retrofit
                val response = apiService.getData(url)
                if (response.isSuccessful) {
                    val responseData = response.body()
                    if (responseData != null) {
                        _responseData.value = response
                    } else {
                        _responseData.value = Response.error(500, null)
                    }
                } else {
                    _responseData.value = Response.error(response.code(), response.errorBody())
                }
            } catch (e: Exception) {
                // Handle errors
                e.printStackTrace()
                _responseData.value = Response.error(500, null)
            }
        }
    }
    fun saveToDatabase(data: Data, places: List<Place>) {
        viewModelScope.launch {
            saveDataToDatabase(data, places)
        }
    }

    private suspend fun saveDataToDatabase(data: Data, places: List<Place>) {
        withContext(Dispatchers.IO) {
            val dataEntity = DataEntity(
                country = data.country,
                countryabbreviation = data.countryabbreviation,
                postcode = data.postcode
            )
            repository.insertData(dataEntity)

            val placeEntities = data.places.map { place ->
                PlaceEntity(
                    dataId = dataEntity.id,
                    latitude = place.latitude,
                    longitude = place.longitude,
                    placename = place.placename,
                    state = place.state,
                    stateabbreviation = place.stateabbreviation
                )
            }
            repository.insertPlaces(placeEntities)
        }
    }
}




