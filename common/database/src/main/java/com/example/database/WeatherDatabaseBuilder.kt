package com.example.database

import android.content.Context
import androidx.room.Room

object WeatherDatabaseBuilder {
    fun build(ctx: Context): WeatherRoomDatabase = Room.databaseBuilder(
        ctx, WeatherRoomDatabase::class.java, "weather-database"
    )
        .fallbackToDestructiveMigration()
        .build()
}