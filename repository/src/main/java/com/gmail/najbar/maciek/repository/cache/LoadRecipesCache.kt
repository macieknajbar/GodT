package com.gmail.najbar.maciek.repository.cache

import com.gmail.najbar.maciek.domain.Recipe
import com.gmail.najbar.maciek.usecase.LoadRecipes

class LoadRecipesCache : LoadRecipes.Cache {

    override fun loadAll(callback: LoadRecipes.Cache.Callback) {
        callback.found(RecipeCache.CACHE.values)
    }

    override fun saveAll(recipes: Collection<Recipe>) {
        RecipeCache.CACHE.clear()

        recipes.forEach {
            RecipeCache.CACHE[it.id] = it
        }
    }
}