package com.gmail.najbar.maciek.usecase

class SearchForRecipesImpl(
        private val gateway: SearchForRecipes.Gateway) : SearchForRecipes {

    val callback = object : SearchForRecipes.Gateway.Callback {

    }

    override fun searchByIngredient(name: String) {
        gateway.searchByIngredient(name, callback)
    }
}