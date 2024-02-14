package com.example.mapcountryzip.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Embedded
import androidx.room.Relation


@Entity(tableName = "data")
data class DataEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val country: String,
    val countryabbreviation: String,
    val  postcode: String
)

@Entity(tableName = "place")
data class PlaceEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val dataId: Int, // Foreign key to associate places with data
    val latitude: String,
    val longitude: String,
    val placename: String,
    val state: String,
    val stateabbreviation: String
)


data class DataWithPlaces(
    @Embedded val data: DataEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "dataId"
    )
    val places: List<PlaceEntity>
)
