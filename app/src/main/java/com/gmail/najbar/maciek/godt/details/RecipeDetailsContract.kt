package com.gmail.najbar.maciek.godt.details

import com.gmail.najbar.maciek.usecase.DisplayDetails

interface RecipeDetailsContract {

    interface DisplayDetailsView {

        /**
         * Displays details of provided recipe.
         *
         * @param   recipe Provided recipe.
         */
        fun displayDetailsOf(recipe: DisplayDetails.Recipe)

    }
}