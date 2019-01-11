package com.gmail.najbar.maciek.usecase

import com.gmail.najbar.maciek.domain.Recipe as RecipeEntity

interface DisplayDetails {

    /**
     * Displays details of a recipe with specified id.
     *
     * @param   recipeId Recipe ID.
     */
    fun of(recipeId: Long)

    /**
     * Data transfer object.
     */
    data class Recipe(val title: String, val description: String, val ingredients: Collection<String>, val imageUrl: String?) {
        companion object {
            fun from(recipe: RecipeEntity) = Recipe(recipe.title, recipe.description, recipe.ingredients.map { it.name }, recipe.image.url)
        }
    }

    interface Gateway {

        /**
         * Loads recipe info for provided recipe id.
         *
         * @param   recipeId Recipe ID.
         * @param   callback Callback.
         */
        fun loadRecipeInfo(recipeId: Long, callback: Callback)

        interface Callback {

            /**
             * Delivers found recipe.
             *
             * @param   recipe Found recipe.
             */
            fun found(recipe: RecipeEntity)
        }
    }

    interface Presenter {

        /**
         * Presents recipe to user.
         *
         * @param   recipe Recipe.
         */
        fun presentRecipeDetails(recipe: Recipe)

    }
}