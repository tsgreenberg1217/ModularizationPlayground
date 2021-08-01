package com.example.data_utility.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cityWeatherCache")
data class CityWeatherCache(
    @PrimaryKey
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "country")
    val country: String,
    @ColumnInfo(name = "lat")
    val lat: Float,
    @ColumnInfo(name = "lon")
    val lon: Float,
    @ColumnInfo(name = "localTime")
    val localTime: Long,
    @ColumnInfo(name = "obsTime")
    val obsTime: String,
    @ColumnInfo(name = "icons")
    val icons: List<String>,
    @ColumnInfo(name = "humidity")
    val humidity: Int,
    @ColumnInfo(name = "feelsLike")
    val feelsLike: Int,
    @ColumnInfo(name = "is_day")
    val is_day: Boolean,
    @ColumnInfo(name = "desc")
    val desc: List<String>

)