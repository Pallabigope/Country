package com.example.mapcountryzip.repository

import androidx.lifecycle.LiveData
import com.example.mapcountryzip.database.DataDao
import com.example.mapcountryzip.database.DataEntity
import com.example.mapcountryzip.database.DataWithPlaces

class CartRepository(private val dataDao: DataDao) {
    fun getCartItems(): LiveData<List<DataWithPlaces>> {
        return dataDao.getDataWithPlaces()
    }

    suspend fun addToCart(data: DataEntity) {
        dataDao.insertData(data)
    }

    suspend fun fetchCartItemsFromDatabase(): List<DataWithPlaces> {
        return dataDao.getDataWithPlacesSync()
    }
}