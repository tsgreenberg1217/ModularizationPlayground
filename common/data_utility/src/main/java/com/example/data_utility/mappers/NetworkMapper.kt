package com.example.data_utility.mappers

import com.example.data_utility.models.NetworkWeatherResponse
import com.example.data_utility.EntityMapper
import com.example.modular_app.models.CityWeatherResult

class NetworkMapper :
    EntityMapper<NetworkWeatherResponse, CityWeatherResult> {
    override fun entityToDomain(enity: NetworkWeatherResponse): CityWeatherResult =
        CityWeatherResult(
            name = enity.location.name,
            country = enity.location.country,
            lat = enity.location.lat,
            lon = enity.location.lon,
            localTime = enity.location.localtime_epoch,
            obsTime = enity.current.observation_time,
            icons = enity.current.weather_icons,
            humidity = enity.current.humidity,
            feelsLike = enity.current.feelslike,
            is_day = enity.current.is_day,
            desc = enity.current.weather_descriptions
        )

    override fun domainToEntity(domain: CityWeatherResult): NetworkWeatherResponse? {
        return null
    }
}