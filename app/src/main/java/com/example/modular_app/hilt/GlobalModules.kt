package com.example.modular_app.hilt

import android.content.Context
import com.example.api.WeatherService
import com.example.base.api.WeatherServiceUtil
import com.example.data_utility.mappers.DbMapper
import com.example.data_utility.mappers.NetworkMapper
import com.example.database.WeatherDatabase
import com.example.database.WeatherRoomDatabase
import com.example.database.WeatherDatabaseBuilder
import dagger.Binds
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
    fun providesWeatherDatabase(@ApplicationContext ctx: Context): WeatherRoomDatabase =
        WeatherDatabaseBuilder.build(ctx)

}

@InstallIn(SingletonComponent::class)
@Module
abstract class WeatherBindings{
    @Binds
    abstract fun bindWeatherDatabase(db:WeatherRoomDatabase):WeatherDatabase
}