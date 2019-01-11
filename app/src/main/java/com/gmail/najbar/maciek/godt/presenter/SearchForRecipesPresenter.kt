package com.gmail.najbar.maciek.godt.presenter

import com.gmail.najbar.maciek.godt.RecipesContract
import com.gmail.najbar.maciek.usecase.SearchForRecipes

class SearchForRecipesPresenter(
        private val view: RecipesContract.SearchForRecipesView) : SearchForRecipes.Presenter {

    override fun presentRecipes(filteredRecipes: Collection<SearchForRecipes.Recipe>) {

    }
}