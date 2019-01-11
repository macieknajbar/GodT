package com.gmail.najbar.maciek.godt

interface RecipesContract {

    /**
     * Data transfer object.
     */
    data class Recipe(val id: Long, val title: String, val description: String, val ingredients: Collection<String>, val imageUrl: String?)

    interface LoadRecipesView {

        /**
         * Displays recipes on the list.
         *
         * @param   recipes Collection of recipes.
         */
        fun displayRecipes(recipes: Collection<Recipe>)
    }

    interface PickRecipeView {

        /**
         * Displays details for recipe with specified id.
         *
         * @param   recipeId Recipe ID.
         */
        fun displayDetailsFor(recipeId: Long)

    }

    interface SearchForRecipesView {

        /**
         * Displays filtered recipes.
         *
         * @param   recipes Collection of recipes.
         */
        fun displayFiltered(recipes: Collection<Recipe>)
    }
}