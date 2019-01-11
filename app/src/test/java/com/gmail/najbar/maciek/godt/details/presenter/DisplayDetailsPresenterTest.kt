package com.gmail.najbar.maciek.godt.details.presenter

import com.gmail.najbar.maciek.godt.details.RecipeDetailsContract
import com.gmail.najbar.maciek.usecase.DisplayDetails
import org.jmock.Expectations
import org.jmock.integration.junit4.JMock
import org.jmock.integration.junit4.JUnit4Mockery
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JMock::class)
class DisplayDetailsPresenterTest {

    private val context = JUnit4Mockery()

    private val view = context.mock(RecipeDetailsContract.DisplayDetailsView::class.java)

    @Test fun `displays details to user`() {
        val recipe = DisplayDetails.Recipe("title", "description", listOf("Egg"), null)
        val presenter = DisplayDetailsPresenter(view)

        context.checking(Expectations().apply {
            oneOf(view).displayDetailsOf(recipe)
        })

        presenter.presentRecipeDetails(recipe)
    }
}