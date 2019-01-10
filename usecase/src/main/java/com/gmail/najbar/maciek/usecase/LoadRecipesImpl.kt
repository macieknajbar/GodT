package com.gmail.najbar.maciek.usecase

class LoadRecipesImpl(
        private val gateway: LoadRecipes.Gateway) : LoadRecipes {

    internal val callback = object : LoadRecipes.Gateway.Callback {

    }

    internal val cacheCallback = object : LoadRecipes.Cache.Callback {

    }

    override fun all() {
        gateway.requestAllRecipes(callback)
    }
}