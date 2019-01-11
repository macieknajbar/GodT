package com.gmail.najbar.maciek.usecase

interface SearchForRecipes {

    /**
     * Searches by provided ingredient name.
     *
     * @param   name Ingredient name.
     */
    fun searchByIngredient(name: String)

    interface Gateway {
        fun searchByIngredient(name: String, callback: Callback)

        interface Callback
    }
}