package com.example.mvvmcompose.network.responses

import com.example.mvvmcompose.network.model.RecipeDto
import com.google.gson.annotations.SerializedName

data class RecipeSearchResponse(
    @SerializedName("count")
    var count: Int,
    @SerializedName("results")
    var recipes: List<RecipeDto>
)