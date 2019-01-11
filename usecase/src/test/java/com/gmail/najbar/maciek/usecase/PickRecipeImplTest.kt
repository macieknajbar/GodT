package com.gmail.najbar.maciek.usecase

import org.jmock.Expectations
import org.jmock.integration.junit4.JMock
import org.jmock.integration.junit4.JUnit4Mockery
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JMock::class)
class PickRecipeImplTest {

    private val context = JUnit4Mockery()

    private val presenter = context.mock(PickRecipe.Presenter::class.java)

    @Test fun `picks a recipe`() {
        val recipeId = 123L
        val pickRecipe = PickRecipeImpl(presenter)

        context.checking(Expectations().apply {
            oneOf(presenter).presentRecipeWithId(recipeId)
        })

        pickRecipe.withId(recipeId)
    }
}