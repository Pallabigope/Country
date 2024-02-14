package com.example.mapcountryzip.data

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("country") val country: String,
    @SerializedName("country abbreviation")  val countryabbreviation: String,
    @SerializedName("places") val places: List<Place>,
    @SerializedName("post code") val postcode: String
)