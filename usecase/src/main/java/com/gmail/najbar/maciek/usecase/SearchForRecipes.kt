package com.gmail.najbar.maciek.usecase

import com.gmail.najbar.maciek.domain.Recipe as RecipeEntity

interface SearchForRecipes {

    /**
     * Searches by provided ingredient name.
     *
     * @param   name Ingredient name.
     */
    fun searchByIngredient(name: String)

    /**
     * Data transfer object.
     */
    data class Recipe(val id: Long, val title: String, val description: String, val imageUrl: String?) {
        companion object {
            fun from(recipe: RecipeEntity) = Recipe(recipe.id, recipe.title, recipe.description, recipe.image.url)
        }
    }

    interface Gateway {
        fun searchByIngredient(name: String, callback: Callback)

        interface Callback {

            /**
             * Returns filtered collection of recipes.
             *
             * @param   recipes Collection of recipes.
             */
            fun filtered(recipes: Collection<RecipeEntity>)
        }
    }

    interface Presenter {

        /**
         * Presents filtered recipes collection.
         *
         * @param   filteredRecipes Collection of filtered recipes.
         */
        fun presentRecipes(filteredRecipes: Collection<Recipe>)
    }
}