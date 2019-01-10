package com.gmail.najbar.maciek.repository.gateway

import com.gmail.najbar.maciek.repository.Recipe
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipesListDetailed {

    @GET("getRecipesListDetailed?size=thumbnail-medium&ratio=1")
    fun getRecipesListDetailed(@Query("from") from: Int = 0, @Query("limit") limit: Int = 50): Call<List<Recipe>>
}