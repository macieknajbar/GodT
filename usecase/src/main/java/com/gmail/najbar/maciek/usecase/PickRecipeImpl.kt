package com.gmail.najbar.maciek.usecase

class PickRecipeImpl(
        private val presenter: PickRecipe.Presenter) : PickRecipe {

    override fun withId(id: Long) {
        presenter.presentRecipeWithId(id)
    }
}