package com.gmail.najbar.maciek.godt

import android.content.Intent
import android.support.test.rule.ActivityTestRule
import com.gmail.najbar.maciek.godt.page.RecipesPage
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test

class RecipesActivityTest {

    @get:Rule val rule = ActivityTestRule<RecipesActivity>(RecipesActivity::class.java, false, false)

    private val recipes: List<RecipesContract.Recipe> = listOf(
            RecipesContract.Recipe(1L, "One", "One desc", listOf("Egg", "Butter"), null),
            RecipesContract.Recipe(2L, "Two", "Two desc", emptyList(), null),
            RecipesContract.Recipe(3L, "Three", "Three desc", emptyList(), null),
            RecipesContract.Recipe(4L, "Four", "Four desc", emptyList(), null))

    init {
        Gateways.loadRecipesGateway(recipes)
    }

    @Test fun scrollsThroughRecipes() {
        val desiredRecipe = recipes.elementAt(3)

        rule.launchActivity(Intent())

        RecipesPage.scrollTo(desiredRecipe)
    }

    @Test fun displaysRecipeDetails() {
        val desiredRecipe = recipes.elementAt(0)

        rule.launchActivity(Intent())

        RecipesPage.scrollTo(desiredRecipe)
        RecipesPage.enter(desiredRecipe)

        RecipesPage.confirmDisplayed(desiredRecipe)
    }
}
