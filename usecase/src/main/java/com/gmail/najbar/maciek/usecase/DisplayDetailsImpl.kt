package com.gmail.najbar.maciek.usecase

import com.gmail.najbar.maciek.domain.Recipe

class DisplayDetailsImpl(
        private val gateway: DisplayDetails.Gateway,
        private val presenter: DisplayDetails.Presenter) : DisplayDetails {

    val callback = object : DisplayDetails.Gateway.Callback {
        override fun found(recipe: Recipe) {
            presenter.presentRecipeDetails(DisplayDetails.Recipe.from(recipe))
        }
    }

    override fun of(recipeId: Long) {
        gateway.loadRecipeInfo(recipeId, callback)
    }
}