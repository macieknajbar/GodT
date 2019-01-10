package com.gmail.najbar.maciek.usecase

class LoadRecipesImpl(
        private val gateway: LoadRecipes.Gateway,
        private val cache: LoadRecipes.Cache) : LoadRecipes {

    internal val gatewayCallback = object : LoadRecipes.Gateway.Callback {

    }

    internal val cacheCallback = object : LoadRecipes.Cache.Callback {

    }

    override fun all() {
        cache.loadAll(cacheCallback)
        gateway.requestAllRecipes(gatewayCallback)
    }
}