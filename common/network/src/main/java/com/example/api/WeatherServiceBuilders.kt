package com.example.base.api

import com.example.api.WeatherService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WeatherServiceUtil {
    private fun createRetrofitClient(): OkHttpClient {
        return OkHttpClient().newBuilder().apply {
            addInterceptor(HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BASIC)
                setLevel(HttpLoggingInterceptor.Level.BODY)
            })
        }.build()
    }

    private fun getGsonBuilder(): Gson = GsonBuilder().create()

    private fun getWeatherApi(gson: Gson, client: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl("http://api.weatherstack.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    private fun buildWeatherService(retrofit: Retrofit.Builder): WeatherService {
        return retrofit.build().create(WeatherService::class.java)
    }

    fun getWeatherService(): WeatherService {
        val client = createRetrofitClient()
        val gson = getGsonBuilder()
        return buildWeatherService(getWeatherApi(gson, client))
    }
}