package com.gmail.najbar.maciek.godt

import com.gmail.najbar.maciek.usecase.LoadRecipes
import org.jmock.Expectations
import org.jmock.integration.junit4.JMock
import org.jmock.integration.junit4.JUnit4Mockery
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JMock::class)
class LoadRecipesPresenterTest {

    private val context = JUnit4Mockery()

    private val view = context.mock(RecipesContract.LoadRecipesView::class.java)

    @Test fun `displays recipes to view`() {
        val recipes = listOf(
                LoadRecipes.Recipe(1L, "One", "desc", emptyList(), null))
        val presenter = LoadRecipesPresenter(view)

        context.checking(Expectations().apply {
            oneOf(view).displayRecipes(recipes.map { RecipesContract.Recipe(it.id, it.title, it.description, it.ingredients, it.imageUrl) })
        })

        presenter.present(recipes)
    }
}