package com.gmail.najbar.maciek.usecase

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
        val searchForRecipes = SearchForRecipesImpl()

        context.checking(Expectations().apply {
            oneOf(gateway).searchByIngredient(name, searchForRecipes.callback)
        })

        searchForRecipes.searchByIngredient(name)
    }
}