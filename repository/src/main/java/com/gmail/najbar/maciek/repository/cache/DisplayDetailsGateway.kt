package com.gmail.najbar.maciek.repository.cache

import com.gmail.najbar.maciek.usecase.DisplayDetails

class DisplayDetailsGateway : DisplayDetails.Gateway {

    override fun loadRecipeInfo(recipeId: Long, callback: DisplayDetails.Gateway.Callback) {
        RecipeCache.CACHE[recipeId]?.let {
            callback.found(it)
        }
    }
}