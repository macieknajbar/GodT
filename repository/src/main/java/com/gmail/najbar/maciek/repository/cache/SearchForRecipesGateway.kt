package com.gmail.najbar.maciek.repository.cache

import com.gmail.najbar.maciek.usecase.SearchForRecipes

class SearchForRecipesGateway : SearchForRecipes.Gateway {

    override fun searchByIngredient(name: String, callback: SearchForRecipes.Gateway.Callback) {
        val recipes = RecipeCache.CACHE.values.filter { it.ingredients.any { ingredient -> ingredient.name == name } }
        callback.filtered(recipes)
    }
}