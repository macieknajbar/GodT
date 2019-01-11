package com.gmail.najbar.maciek.repository.cache

import com.gmail.najbar.maciek.domain.Recipe

object RecipeCache {
    val CACHE = mutableMapOf<Long, Recipe>()
}