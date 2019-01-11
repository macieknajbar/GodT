package com.gmail.najbar.maciek.usecase

interface PickRecipe {

    /**
     * Picks a recipe.
     *
     * @param   id Recipe id.
     */
    fun withId(id: Long)

    interface Presenter {

        /**
         * Presents recipe's id.
         *
         * @param   recipeId Recipe ID.
         */
        fun presentRecipeWithId(recipeId: Long)
    }
}