package com.example.data_utility.models

data class CityWeatherResult(
    val name:String,
    val country:String,
    val lat: Float,
    val lon:Float,
    val localTime:Long,
    val obsTime: String,
    val icons:List<String>,
    val humidity:Int,
    val feelsLike:Int,
    val is_day:Boolean,
    val desc:List<String>

)