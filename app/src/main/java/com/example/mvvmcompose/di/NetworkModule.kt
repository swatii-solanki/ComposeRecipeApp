package com.example.mvvmcompose.di

import com.example.mvvmcompose.network.NetworkService
import com.example.mvvmcompose.network.model.RecipeDtoMapper
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRecipeMapper(): RecipeDtoMapper {
        return RecipeDtoMapper()
    }

    @Singleton
    @Provides
    fun provideNetworkService(): NetworkService {
        return Retrofit.Builder()
                .baseUrl("https://food2fork.ca/api/recipe/")
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
                .create(NetworkService::class.java)
    }

    @Singleton
    @Provides
    @Named("auth_token")
    fun provideAuthToken()  : String{
        return "Token 9c8b06d329136da358c2d00e76946b0111ce2c48"
    }



}