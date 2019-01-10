package com.gmail.najbar.maciek.usecase

interface LoadRecipes {

    /**
     * Loads all recipes.
     */
    fun all()

    interface Gateway {

        /**
         * Requests all recipes.
         *
         * @param   callback Callback.
         */
        fun requestAllRecipes(callback: Callback)

        interface Callback
    }

    interface Cache {
        fun loadAll(callback: Callback)

        interface Callback
    }
}