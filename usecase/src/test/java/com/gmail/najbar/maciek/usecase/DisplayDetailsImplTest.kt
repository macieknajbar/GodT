package com.gmail.najbar.maciek.usecase

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
        val displayDetails = DisplayDetailsImpl(gateway)

        context.checking(Expectations().apply {
            oneOf(gateway).loadRecipeInfo(recipeId, displayDetails.callback)
        })

        displayDetails.of(recipeId)
    }
}