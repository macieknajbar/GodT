package com.gmail.najbar.maciek.godt

import com.gmail.najbar.maciek.repository.gateway.RetrofitLoadRecipesGateway
import com.gmail.najbar.maciek.usecase.LoadRecipes

object Gateways {

    fun loadRecipesGateway(): LoadRecipes.Gateway = RetrofitLoadRecipesGateway()
}