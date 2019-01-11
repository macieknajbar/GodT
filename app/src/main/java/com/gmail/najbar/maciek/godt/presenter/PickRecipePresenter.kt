package com.gmail.najbar.maciek.godt.presenter

import com.gmail.najbar.maciek.godt.RecipesContract
import com.gmail.najbar.maciek.usecase.PickRecipe

class PickRecipePresenter(
        private val view: RecipesContract.PickRecipeView) : PickRecipe.Presenter {

    override fun presentRecipeWithId(recipeId: Long) {
        view.displayDetailsFor(recipeId)
    }
}