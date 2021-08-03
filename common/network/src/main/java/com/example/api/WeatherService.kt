package com.example.api

import com.example.data_utility.models.NetworkWeatherResponse
import com.example.network.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Query

object NetworkUtil {
    const val BaseUrl = "http://api.weatherstack.com/"
}

interface WeatherService {

    @GET("current")
    suspend fun getWeatherForCity(
        @Query("query") city: String,
        @Query("access_key") key: String = BuildConfig.WEATHER_API_KEY
    ): NetworkWeatherResponse
}