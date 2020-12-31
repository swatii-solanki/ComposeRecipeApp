package com.example.mvvmcompose.repository

import com.example.mvvmcompose.domain.model.Recipe
import com.example.mvvmcompose.network.NetworkService
import com.example.mvvmcompose.network.model.RecipeDtoMapper

class RecipeRepository_Impl(
    private val networkService: NetworkService,
    private val mapper: RecipeDtoMapper
) : RecipeRepository {
    override suspend fun search(token: String, page: Int, query: String): List<Recipe> {
        return mapper.toDomainList(networkService.search(token, page, query).recipes)
    }

    override suspend fun get(token: String, id: Int): Recipe {
        return mapper.mapToDomainModel(networkService.get(token, id))
    }

}