package com.gmail.najbar.maciek.godt.presenter

import com.gmail.najbar.maciek.godt.RecipesContract
import com.gmail.najbar.maciek.usecase.LoadRecipes

class LoadRecipesPresenter(
        private val view: RecipesContract.LoadRecipesView) : LoadRecipes.Presenter {

    override fun present(recipes: Collection<LoadRecipes.Recipe>) {
        view.displayRecipes(recipes.map { RecipesContract.Recipe(it.id, it.title, it.description, it.ingredients, it.imageUrl) })
    }
}