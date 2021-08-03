package com.example.modular_app.hilt

import com.example.data_utility.mappers.DbMapper
import com.example.data_utility.mappers.NetworkMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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

}