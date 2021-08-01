package com.example.database

import android.content.Context
import androidx.room.Room

object WeatherDatabaseBuilder {
    fun build(ctx: Context): WeatherDatabase = Room.databaseBuilder(
        ctx, WeatherDatabase::class.java, "weather-database"
    )
        .fallbackToDestructiveMigration()
        .build()
}