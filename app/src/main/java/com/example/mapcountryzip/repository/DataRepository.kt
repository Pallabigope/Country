package com.example.mapcountryzip.repository

import androidx.lifecycle.LiveData
import com.example.mapcountryzip.database.DataDao
import com.example.mapcountryzip.database.DataEntity
import com.example.mapcountryzip.database.DataWithPlaces
import com.example.mapcountryzip.database.PlaceEntity

class DataRepository(private val dataDao: DataDao) {
    suspend fun insertData(data: DataEntity) {
        dataDao.insertData(data)
    }

    suspend fun insertPlaces(places: List<PlaceEntity>) {
        dataDao.insertPlaces(places)
    }

    fun getDataWithPlaces(): LiveData<List<DataWithPlaces>> {
        return dataDao.getDataWithPlaces()
    }
}