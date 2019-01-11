package com.gmail.najbar.maciek.usecase

class DisplayDetailsImpl(
        private val gateway: DisplayDetails.Gateway) : DisplayDetails {

    val callback = object : DisplayDetails.Gateway.Callback {
        override fun found(recipe: DisplayDetails.Recipe) {

        }
    }

    override fun of(recipeId: Long) {
        gateway.loadRecipeInfo(recipeId, callback)
    }
}