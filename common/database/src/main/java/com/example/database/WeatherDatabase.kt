package com.example.database

interface WeatherDatabase {
    fun cityDao(): CityDao
}