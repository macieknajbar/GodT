package com.gmail.najbar.maciek.usecase

import com.gmail.najbar.maciek.domain.Recipe

class SearchForRecipesImpl(
        private val gateway: SearchForRecipes.Gateway) : SearchForRecipes {

    val callback = object : SearchForRecipes.Gateway.Callback {
        override fun filtered(recipes: Collection<Recipe>) {
            
        }
    }

    override fun searchByIngredient(name: String) {
        gateway.searchByIngredient(name, callback)
    }
}