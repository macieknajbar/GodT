package com.gmail.najbar.maciek.godt

import com.gmail.najbar.maciek.repository.gateway.FakeLoadRecipesGateway
import com.gmail.najbar.maciek.usecase.LoadRecipes

object Gateways {

    private var loadRecipesGateway: LoadRecipes.Gateway? = null
    fun loadRecipesGateway(response: List<RecipesContract.Recipe>? = null): LoadRecipes.Gateway {
        if (loadRecipesGateway == null) {
            loadRecipesGateway = FakeLoadRecipesGateway(response?.map { LoadRecipes.Recipe(it.id, it.title, it.description, it.ingredients, it.imageUrl) })
        }
        return loadRecipesGateway!!
    }

}