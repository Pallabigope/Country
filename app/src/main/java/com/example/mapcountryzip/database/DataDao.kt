package com.example.mapcountryzip.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface DataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(data: DataEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlaces(places: List<PlaceEntity>)

    @Transaction
    @Query("SELECT * FROM data")
    fun getDataWithPlaces(): LiveData<List<DataWithPlaces>>

    @Transaction
    @Query("SELECT * FROM data")
    suspend fun getDataWithPlacesSync(): List<DataWithPlaces>
}