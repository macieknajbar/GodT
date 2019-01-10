package com.gmail.najbar.maciek.repository

import com.gmail.najbar.maciek.domain.Ingredient
import com.gmail.najbar.maciek.usecase.LoadRecipes
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import com.gmail.najbar.maciek.domain.Image as ImageValue
import com.gmail.najbar.maciek.domain.Recipe as RecipeEntity

class RetrofitLoadRecipesGateway : LoadRecipes.Gateway {

    override fun requestAllRecipes(callback: LoadRecipes.Gateway.Callback) {
        val retrofit = Retrofit.Builder()
                .client(OkHttpClient())
                .baseUrl("https://www.godt.no/api")
                .build()

        retrofit.create(RecipesListDetailed::class.java)
                .getRecipesListDetailed()
                .enqueue(object : Callback<List<Recipe>> {
                    override fun onFailure(call: Call<List<Recipe>>, t: Throwable) {

                    }

                    override fun onResponse(call: Call<List<Recipe>>, response: Response<List<Recipe>>) {
                        response.body()?.let {
                            callback.gotYour(it.map { recipe ->
                                val ingredients = recipe.ingredients
                                        .flatMap { group -> group.elements }
                                        .flatMap { element -> setOf(Ingredient(element.id.toLong(), element.name)) }

                                RecipeEntity(recipe.id.toLong(), recipe.title, recipe.description, ingredients, ImageValue(recipe.images.first().url))
                            })
                        }
                    }
                })
    }
}