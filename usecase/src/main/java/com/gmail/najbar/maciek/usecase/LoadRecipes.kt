package com.gmail.najbar.maciek.usecase

import com.gmail.najbar.maciek.domain.Recipe as RecipeEntity

interface LoadRecipes {

    /**
     * Loads all recipes.
     */
    fun all()

    /**
     * Recipe DTO.
     */
    data class Recipe(val id: Long, val title: String, val description: String, val ingredients: Collection<String>, val imageUrl: String?) {
        companion object {
            fun from(recipe: RecipeEntity) = Recipe(recipe.id, recipe.title, recipe.description, recipe.ingredients.map { it.name }, recipe.image.url)
        }
    }

    interface Gateway {

        /**
         * Requests all recipes.
         *
         * @param   callback Callback.
         */
        fun requestAllRecipes(callback: Callback)

        interface Callback {

            /**
             * Returns recipes pulled through gateway.
             *
             * @param   recipes Collection of recipes.
             */
            fun gotYour(recipes: Collection<RecipeEntity>)
        }
    }

    interface Cache {

        /**
         * Loads all cached recipes.
         *
         * @param   callback Callback.
         */
        fun loadAll(callback: Callback)

        /**
         * Caches provided recipes.
         *
         * @param   recipes Recipes.
         */
        fun cacheAll(recipes: Collection<RecipeEntity>)

        interface Callback {

            /**
             * Returns found cached recipes.
             *
             * @param   recipes Collection of recipes.
             */
            fun found(recipes: Collection<RecipeEntity>)
        }
    }

    interface Presenter {

        /**
         * Presents collection of recipes.
         *
         * @param   recipes Collection of recipes.
         */
        fun present(recipes: Collection<Recipe>)
    }
}