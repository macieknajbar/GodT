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

    @Test fun `loads cache recipes before requesting from remote`() {
        val loadRecipes = LoadRecipesImpl(
                gateway,
                cache)

        context.checking(Expectations().apply {
            val sequence = context.sequence("loading-recipe")
            oneOf(cache).loadAll(loadRecipes.cacheCallback); inSequence(sequence)
            oneOf(gateway).requestAllRecipes(loadRecipes.gatewayCallback); inSequence(sequence)
        })

        loadRecipes.all()
    }
}