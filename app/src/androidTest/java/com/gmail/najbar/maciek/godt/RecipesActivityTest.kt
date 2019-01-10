package com.gmail.najbar.maciek.godt

import android.content.Intent
import android.support.test.rule.ActivityTestRule
import com.gmail.najbar.maciek.godt.page.RecipesPage
import org.junit.Rule
import org.junit.Test

class RecipesActivityTest {

    @get:Rule val rule = ActivityTestRule<RecipesActivity>(RecipesActivity::class.java, false, false)

    @Test fun scrollsThroughRecipes() {
        val desiredTitle = "My desire"
        Gateways.loadRecipesGateway(listOf(
                RecipesContract.Recipe(1L, "One", "", emptyList(), null),
                RecipesContract.Recipe(2L, "Two", "Two", emptyList(), null),
                RecipesContract.Recipe(3L, "Three", "Three", emptyList(), null),
                RecipesContract.Recipe(4L, desiredTitle, "Four", emptyList(), null)))

        rule.launchActivity(Intent())

        RecipesPage.scrollTo(desiredTitle)
    }
}
