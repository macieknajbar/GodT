package com.gmail.najbar.maciek.godt.presenter

import com.gmail.najbar.maciek.godt.RecipesContract
import org.jmock.Expectations
import org.jmock.integration.junit4.JMock
import org.jmock.integration.junit4.JUnit4Mockery
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JMock::class)
class PickRecipePresenterTest {

    private val context = JUnit4Mockery()

    private val view = context.mock(RecipesContract.PickRecipeView::class.java)

    @Test fun `displays picked recipe`() {
        val recipeId = 123L
        val presenter = PickRecipePresenter(view)

        context.checking(Expectations().apply {
            oneOf(view).displayDetailsFor(recipeId)
        })

        presenter.presentRecipeWithId(recipeId)
    }
}