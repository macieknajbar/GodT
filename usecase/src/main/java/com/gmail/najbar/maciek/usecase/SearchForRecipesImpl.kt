package com.gmail.najbar.maciek.usecase

import com.gmail.najbar.maciek.domain.Recipe

class SearchForRecipesImpl(
        private val gateway: SearchForRecipes.Gateway,
        private val presenter: SearchForRecipes.Presenter) : SearchForRecipes {

    val callback = object : SearchForRecipes.Gateway.Callback {
        override fun filtered(recipes: Collection<Recipe>) {
            presenter.presentRecipes(recipes.map { SearchForRecipes.Recipe.from(it) })
        }
    }

    override fun searchByIngredient(name: String) {
        gateway.searchByIngredient(name, callback)
    }
}