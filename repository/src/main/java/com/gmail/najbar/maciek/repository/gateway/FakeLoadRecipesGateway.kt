package com.gmail.najbar.maciek.repository.gateway

import com.gmail.najbar.maciek.domain.Image
import com.gmail.najbar.maciek.domain.Ingredient
import com.gmail.najbar.maciek.domain.Recipe
import com.gmail.najbar.maciek.usecase.LoadRecipes

class FakeLoadRecipesGateway(private val response: Collection<LoadRecipes.Recipe>?) : LoadRecipes.Gateway {
    override fun requestAllRecipes(callback: LoadRecipes.Gateway.Callback) {
        callback.gotYour(response?.map { Recipe.from(it.id, it.title, it.description, it.imageUrl, it.ingredients.mapIndexed { index, s -> Ingredient.from(index.toLong(), s) })} ?: emptyList())
    }
}