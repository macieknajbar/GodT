package com.gmail.najbar.maciek.usecase

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

    @Test fun `requests for recipes through gateway`() {
        val loadRecipes = LoadRecipesImpl(
                gateway,
                NoOp.of(LoadRecipes.Cache::class.java))

        context.checking(Expectations().apply {
            oneOf(gateway).requestAllRecipes(loadRecipes.gatewayCallback)
        })

        loadRecipes.all()
    }

    @Test fun `reads information from cache`() {
        val loadRecipes = LoadRecipesImpl(
                NoOp.of(LoadRecipes.Gateway::class.java),
                cache)

        context.checking(Expectations().apply {
            oneOf(cache).loadAll(loadRecipes.cacheCallback)
        })

        loadRecipes.all()
    }
}