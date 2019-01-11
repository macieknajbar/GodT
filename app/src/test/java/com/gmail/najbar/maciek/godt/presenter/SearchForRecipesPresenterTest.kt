package com.gmail.najbar.maciek.godt.presenter

import com.gmail.najbar.maciek.godt.RecipesContract
import com.gmail.najbar.maciek.usecase.SearchForRecipes
import org.jmock.Expectations
import org.jmock.integration.junit4.JMock
import org.jmock.integration.junit4.JUnit4Mockery
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JMock::class)
class SearchForRecipesPresenterTest {

    private val context = JUnit4Mockery()

    private val view = context.mock(RecipesContract.SearchForRecipesView::class.java)

    @Test fun `displays filtered recipes to user`() {
        val recipes = listOf(
                SearchForRecipes.Recipe(1L, "One", "one", "image_url"))
        val presenter = SearchForRecipesPresenter(view)

        context.checking(Expectations().apply {
            oneOf(view).displayFiltered(recipes.map { RecipesContract.Recipe(it.id, it.title, it.description, emptyList(), it.imageUrl) })
        })

        presenter.presentRecipes(recipes)
    }
}