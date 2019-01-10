package com.gmail.najbar.maciek.usecase

import com.gmail.najbar.maciek.domain.Ingredient
import com.gmail.najbar.maciek.domain.Recipe
import org.jmock.Expectations
import org.jmock.integration.junit4.JMock
import org.jmock.integration.junit4.JUnit4Mockery
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JMock::class)
class LoadRecipesImplTest {

    private val context = JUnit4Mockery()

    private val gateway = context.mock(LoadRecipes.Gateway::class.java)
    private val cache = context.mock(LoadRecipes.Cache::class.java)
    private val presenter = context.mock(LoadRecipes.Presenter::class.java)

    @Test fun `loads cache recipes before requesting from remote`() {
        val loadRecipes = LoadRecipesImpl(
                gateway,
                cache,
                presenter)

        context.checking(Expectations().apply {
            val sequence = context.sequence("loading-recipe")
            oneOf(cache).loadAll(loadRecipes.cacheCallback); inSequence(sequence)
            oneOf(gateway).requestAllRecipes(loadRecipes.gatewayCallback); inSequence(sequence)
        })

        loadRecipes.all()
    }

    @Test fun `presents caches recipes to user`() {
        val recipes = listOf(
                Recipe.from(1L, "Jam Sandwich", "Sandwich covered with JAM!", "http://jam_sandwich.jpg", listOf(Ingredient.from(1L, "Jam"), Ingredient.from(2L, "Sandwich"))),
                Recipe.from(2L, "Scrambled eggs", "Fried smashed eggs", "http://scrambled_eggs.png", listOf(Ingredient.from(3L, "Egg"))),
                Recipe.from(3L, "Peanut butter fingers", "Put your fingers into a jar and pull out fingers covered with peanut butter", "", listOf(Ingredient.from(4L, "Peanut butter"))))
        val loadRecipes = LoadRecipesImpl(
                NoOp.of(LoadRecipes.Gateway::class.java),
                fakeCacheWith(recipes),
                presenter)

        context.checking(Expectations().apply {
            val expected = recipes.map { LoadRecipes.Recipe.from(it) }
            oneOf(presenter).present(expected)
        })

        loadRecipes.all()
    }

    @Test fun `caches requested recipes`() {
        val recipes = listOf(
                Recipe.from(1L, "Jam Sandwich", "Sandwich covered with JAM!", "http://jam_sandwich.jpg", listOf(Ingredient.from(1L, "Jam"), Ingredient.from(2L, "Sandwich"))),
                Recipe.from(2L, "Scrambled eggs", "Fried smashed eggs", "http://scrambled_eggs.png", listOf(Ingredient.from(3L, "Egg"))),
                Recipe.from(3L, "Peanut butter fingers", "Put your fingers into a jar and pull out fingers covered with peanut butter", "", listOf(Ingredient.from(4L, "Peanut butter"))))
        val loadRecipes = LoadRecipesImpl(
                fakeGatewayReturns(recipes),
                cache,
                NoOp.of(LoadRecipes.Presenter::class.java))

        context.checking(Expectations().apply {
            oneOf(cache).cacheAll(recipes)
            allowing(cache).loadAll(loadRecipes.cacheCallback)
        })

        loadRecipes.all()
    }

    private fun fakeGatewayReturns(recipes: Collection<Recipe>) = object : LoadRecipes.Gateway {
        override fun requestAllRecipes(callback: LoadRecipes.Gateway.Callback) {
            callback.gotYour(recipes)
        }
    }

    private fun fakeCacheWith(recipes: Collection<Recipe>) = object : LoadRecipes.Cache {
        override fun loadAll(callback: LoadRecipes.Cache.Callback) {
            callback.found(recipes)
        }

        override fun cacheAll(recipes: Collection<Recipe>) {}
    }
}