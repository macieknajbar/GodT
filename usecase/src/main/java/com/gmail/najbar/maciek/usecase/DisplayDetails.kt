package com.gmail.najbar.maciek.usecase

interface DisplayDetails {

    /**
     * Displays details of a recipe with specified id.
     *
     * @param   recipeId Recipe ID.
     */
    fun of(recipeId: Long)

    interface Gateway {

        /**
         * Loads recipe info for provided recipe id.
         *
         * @param   recipeId Recipe ID.
         * @param   callback Callback.
         */
        fun loadRecipeInfo(recipeId: Long, callback: Callback)

        interface Callback
    }
}