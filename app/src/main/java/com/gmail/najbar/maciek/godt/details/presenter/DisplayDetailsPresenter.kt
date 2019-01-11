package com.gmail.najbar.maciek.godt.details.presenter

import com.gmail.najbar.maciek.godt.details.RecipeDetailsContract
import com.gmail.najbar.maciek.usecase.DisplayDetails

class DisplayDetailsPresenter(
        private val view: RecipeDetailsContract.DisplayDetailsView): DisplayDetails.Presenter {

    override fun presentRecipeDetails(recipe: DisplayDetails.Recipe) {
        view.displayDetailsOf(recipe)
    }
}