package com.example.mapcountryzip.data

import com.google.gson.annotations.SerializedName

data class Place(
    @SerializedName("latitude")val latitude: String,
    @SerializedName("longitude") val longitude: String,
    @SerializedName("place name")   val placename: String,
    @SerializedName("state") val state: String,
    @SerializedName("state abbreviation") val stateabbreviation: String
)