package com.example.modular_app.hilt

import com.example.api.WeatherService
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@EntryPoint
@InstallIn(SingletonComponent::class)
interface WeatherDependancies {
    fun weatherService(): WeatherService
}