package com.gmail.najbar.maciek.repository.gateway

import com.gmail.najbar.maciek.repository.Recipe
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RecipesListDetailed {

    @GET("/getRecipesListDetailed?size=thumbnail-medium&ratio=1&limit={limit}&from={from}")
    fun getRecipesListDetailed(@Path("from") from: Int = 0, @Path("limit") limit: Int = 50): Call<List<Recipe>>
}