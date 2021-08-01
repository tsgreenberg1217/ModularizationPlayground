package com.example.modular_app.hilt

import android.content.Context
import androidx.room.Room
import com.example.api.WeatherService
import com.example.base.api.WeatherServiceUtil
import com.example.data_utility.mappers.DbMapper
import com.example.data_utility.mappers.NetworkMapper
import com.example.database.WeatherDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GlobalModules {

    @Singleton
    @Provides
    fun providesDbMapper(): DbMapper = DbMapper()

    @Singleton
    @Provides
    fun providesNetworkMapper(): NetworkMapper = NetworkMapper()

    @Singleton
    @Provides
    fun provideWeatherService(): WeatherService {
        return WeatherServiceUtil.getWeatherService()
    }


    @Singleton
    @Provides
    fun providesWeatherDatabase(@ApplicationContext ctx: Context): WeatherDatabase =
        Room.databaseBuilder(
            ctx, WeatherDatabase::class.java, "weather-database"
        )
            .fallbackToDestructiveMigration()
            .build()

}