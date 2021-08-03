package com.example.data_utility.models

import com.google.gson.annotations.Expose



data class NetworkWeatherResponse(
    @Expose var location: NetworkLocation,
    @Expose var current: NetworkCurrent
)

data class NetworkLocation(
    @Expose var name: String,
    @Expose var country: String,
    @Expose var region: String,
    @Expose var lat: Float,
    @Expose var lon: Float,
    @Expose var timezone_id: String,
    @Expose var localtime: String,
    @Expose var localtime_epoch: Long,
    @Expose var utc_offset: Double
)

data class NetworkCurrent(
    @Expose var observation_time: String,
    @Expose var temperature: Int,
    @Expose var weather_code: Int,
    @Expose var weather_icons: List<String>,
    @Expose var weather_descriptions: List<String>,
    @Expose var wind_speed: Int,
    @Expose var wind_degree: Int,
    @Expose var wind_dir: String,
    @Expose var pressure: Int,
    @Expose var precip: Double,
    @Expose var humidity: Int,
    @Expose var cloudcover: Int,
    @Expose var feelslike: Int,
    @Expose var uv_index: Int,
    @Expose var visibility: Int,
    @Expose var is_day: Boolean
)