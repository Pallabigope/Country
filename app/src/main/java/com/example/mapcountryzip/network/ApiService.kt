package com.example.mapcountryzip.network

import com.example.mapcountryzip.data.Data
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET
    suspend fun getData(@Url url: String): Response<Data>
}

