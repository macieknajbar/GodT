package com.gmail.najbar.maciek.usecase

import com.gmail.najbar.maciek.domain.Ingredient
import com.gmail.najbar.maciek.domain.Recipe
import org.jmock.Expectations
import org.jmock.integration.junit4.JMock
import org.jmock.integration.junit4.JUnit4Mockery
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JMock::class)
class DisplayDetailsImplTest {

    private val context = JUnit4Mockery()

    private val gateway = context.mock(DisplayDetails.Gateway::class.java)

    @Test fun `retrieves recipe details`() {
        val recipeId = 123L
        val displayDetails = DisplayDetailsImpl(
                gateway,
                presenter)

        context.checking(Expectations().apply {
            oneOf(gateway).loadRecipeInfo(recipeId, displayDetails.callback)
        })

        displayDetails.of(recipeId)
    }

    private val presenter = context.mock(DisplayDetails.Presenter::class.java)

    @Test fun `presents recipe to user`() {
        val recipe = Recipe.from(111L, "title", "description", "url", listOf(Ingredient.from(1L, "a")))
        val displayDetails = DisplayDetailsImpl(
                fakeGateway(recipe),
                presenter)

        context.checking(Expectations().apply {
            oneOf(presenter).presentRecipeDetails(DisplayDetails.Recipe.from(recipe))
        })

        displayDetails.of(111L)
    }

    private fun fakeGateway(recipe: Recipe) = object : DisplayDetails.Gateway {
        override fun loadRecipeInfo(recipeId: Long, callback: DisplayDetails.Gateway.Callback) {
            callback.found(recipe)
        }
    }
}