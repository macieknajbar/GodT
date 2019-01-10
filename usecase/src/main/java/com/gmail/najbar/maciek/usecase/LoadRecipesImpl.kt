package com.gmail.najbar.maciek.usecase

import com.gmail.najbar.maciek.domain.Recipe as RecipeEntity

class LoadRecipesImpl(
        private val gateway: LoadRecipes.Gateway,
        private val cache: LoadRecipes.Cache) : LoadRecipes {

    internal val gatewayCallback = object : LoadRecipes.Gateway.Callback {

    }

    internal val cacheCallback = object : LoadRecipes.Cache.Callback {
        override fun found(recipes: Collection<RecipeEntity>) {

        }
    }

    override fun all() {
        cache.loadAll(cacheCallback)
        gateway.requestAllRecipes(gatewayCallback)
    }
}