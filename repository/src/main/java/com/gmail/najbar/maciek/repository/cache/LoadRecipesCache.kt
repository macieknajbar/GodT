package com.gmail.najbar.maciek.repository.cache

import com.gmail.najbar.maciek.domain.Recipe
import com.gmail.najbar.maciek.usecase.LoadRecipes

class LoadRecipesCache : LoadRecipes.Cache {

    override fun loadAll(callback: LoadRecipes.Cache.Callback) {

    }

    override fun saveAll(recipes: Collection<Recipe>) {

    }
}