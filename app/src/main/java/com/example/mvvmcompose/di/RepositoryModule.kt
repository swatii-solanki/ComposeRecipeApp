package com.example.mvvmcompose.di

import com.example.mvvmcompose.network.NetworkService
import com.example.mvvmcompose.network.model.RecipeDtoMapper
import com.example.mvvmcompose.repository.RecipeRepository
import com.example.mvvmcompose.repository.RecipeRepository_Impl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(
            networkService: NetworkService,
            recipeDtoMapper: RecipeDtoMapper
    ): RecipeRepository {
        return RecipeRepository_Impl(networkService, recipeDtoMapper)
    }
}