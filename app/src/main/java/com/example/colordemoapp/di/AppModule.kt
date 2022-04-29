package com.example.colordemoapp.di

import com.example.colordemoapp.common.Constants.BASE_URL
import com.example.colordemoapp.data.remote.ColorsApi
import com.example.colordemoapp.data.repository.ColorsRepositoryImplementation
import com.example.colordemoapp.domain.repository.ColorsRepository
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideColorsApi(): ColorsApi {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ColorsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideColorsRepository(): ColorsRepository {
        return ColorsRepositoryImplementation(provideColorsApi())
    }

}