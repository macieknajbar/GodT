package com.gmail.najbar.maciek.usecase

import com.gmail.najbar.maciek.domain.Recipe as RecipeEntity

class LoadRecipesImpl(
        private val gateway: LoadRecipes.Gateway,
        private val cache: LoadRecipes.Cache,
        private val presenter: LoadRecipes.Presenter) : LoadRecipes {

    internal val gatewayCallback = object : LoadRecipes.Gateway.Callback {
        override fun gotYour(recipes: Collection<com.gmail.najbar.maciek.domain.Recipe>) {
            cache.saveAll(recipes)
        }
    }

    internal val cacheCallback = object : LoadRecipes.Cache.Callback {
        override fun found(recipes: Collection<RecipeEntity>) {
            presenter.present(recipes.map { LoadRecipes.Recipe.from(it) })
        }
    }

    override fun all() {
        cache.loadAll(cacheCallback)
        gateway.requestAllRecipes(gatewayCallback)
    }
}