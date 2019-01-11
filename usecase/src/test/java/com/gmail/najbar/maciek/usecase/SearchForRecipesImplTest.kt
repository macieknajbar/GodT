package com.gmail.najbar.maciek.usecase

import com.gmail.najbar.maciek.domain.Recipe
import org.jmock.Expectations
import org.jmock.integration.junit4.JMock
import org.jmock.integration.junit4.JUnit4Mockery
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JMock::class)
class SearchForRecipesImplTest {

    private val context = JUnit4Mockery()

    private val gateway = context.mock(SearchForRecipes.Gateway::class.java)

    @Test fun `searches for recipes by ingredient`() {
        val name = "ingredient name"
        val searchForRecipes = SearchForRecipesImpl(gateway)

        context.checking(Expectations().apply {
            oneOf(gateway).searchByIngredient(name, searchForRecipes.callback)
        })

        searchForRecipes.searchByIngredient(name)
    }

    private val presenter = context.mock(SearchForRecipes.Presenter::class.java)

    @Test fun `presents recipes to user`() {
        val name = "some"
        val recipes = listOf(
                Recipe.from(0L, "Zero", "zero", null, emptyList()))
        val searchForRecipes = SearchForRecipesImpl(
                fakeGateway(recipes))

        context.checking(Expectations().apply {
            oneOf(presenter).presentRecipes(recipes.map { SearchForRecipes.Recipe.from(it) })
        })

        searchForRecipes.searchByIngredient(name)
    }

    private fun fakeGateway(recipes: Collection<Recipe>) = object : SearchForRecipes.Gateway {
        override fun searchByIngredient(name: String, callback: SearchForRecipes.Gateway.Callback) {
            callback.filtered(recipes)
        }
    }
}