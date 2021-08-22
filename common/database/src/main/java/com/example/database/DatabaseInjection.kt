package com.example.database

import android.content.Context
import androidx.room.Room
import com.example.data_utility.mappers.DbMapper
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RoomModule{

    @Singleton
    @Provides
    fun providesWeatherDatabase(@ApplicationContext ctx: Context): WeatherRoomDatabase {
        return Room.databaseBuilder(
            ctx, WeatherRoomDatabase::class.java, "weather-database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

}


@InstallIn(SingletonComponent::class)
@Module
object DaoModule {

    @Provides
    fun providesCityDao(db: WeatherDatabase): CityDao = db.cityDao()
}


@InstallIn(SingletonComponent::class)
@Module
abstract class WeatherDatabaseBindings {
    @Binds
    abstract fun bindWeatherDatabase(db: WeatherRoomDatabase): WeatherDatabase
}


@Module
@InstallIn(SingletonComponent::class)
object DatabaseMappers {

    @Provides
    fun providesDbMapper(): DbMapper = DbMapper()

}