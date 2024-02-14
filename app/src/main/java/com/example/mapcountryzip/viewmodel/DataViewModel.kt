package com.example.mapcountryzip.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mapcountryzip.database.DataDao
import com.example.mapcountryzip.database.DataEntity
import com.example.mapcountryzip.database.DataWithPlaces
import com.example.mapcountryzip.repository.CartRepository
import kotlinx.coroutines.launch

class DataViewModel(private val repository: CartRepository) : ViewModel() {
    constructor(dataDao: DataDao) : this(CartRepository(dataDao))

    // LiveData to observe the cart items
    val cartItems: LiveData<List<DataWithPlaces>> = repository.getCartItems()

    // Function to add data to cart
    fun addToCart(data: DataEntity) {
        viewModelScope.launch {
            repository.addToCart(data)
        }
    }

    // Function to fetch cart items from the database
    suspend fun fetchCartItemsFromDatabase(): List<DataWithPlaces> {
        return repository.fetchCartItemsFromDatabase()
    }
}