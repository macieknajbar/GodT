package com.gmail.najbar.maciek.godt

import android.content.Intent
import android.support.test.rule.ActivityTestRule
import com.gmail.najbar.maciek.godt.page.RecipesPage
import org.junit.Rule
import org.junit.Test

class RecipesActivityTest {

    @get:Rule val rule = ActivityTestRule<RecipesActivity>(RecipesActivity::class.java, false, false)

    private val eggIngredient = "Egg"
    private val recipes: List<RecipesContract.Recipe> = listOf(
            RecipesContract.Recipe(1L, "One", "One desc", listOf(eggIngredient, "Butter"), null),
            RecipesContract.Recipe(2L, "Two", "Two desc", emptyList(), null),
            RecipesContract.Recipe(3L, "Three", "Three desc", listOf(eggIngredient), null),
            RecipesContract.Recipe(4L, "Four", "Four desc", emptyList(), null))

    init {
        Gateways.loadRecipesGateway(recipes)
    }

    @Test fun scrollsThroughRecipes() {
        val desiredRecipe = recipes[3]

        rule.launchActivity(Intent())

        RecipesPage.scrollTo(desiredRecipe)
    }

    @Test fun displaysRecipeDetails() {
        val desiredRecipe = recipes[0]

        rule.launchActivity(Intent())

        RecipesPage.scrollTo(desiredRecipe)
        RecipesPage.enter(desiredRecipe)

        RecipesPage.confirmDisplayedDetailsOf(desiredRecipe)
    }

    @Test fun searchesForRecipesByIngredients() {
        rule.launchActivity(Intent())

        RecipesPage.searchFor(eggIngredient)

        RecipesPage.confirmDisplayed(recipes[0])
        RecipesPage.confirmDisplayed(recipes[2])
        RecipesPage.cannotSee(recipes[1])
        RecipesPage.cannotSee(recipes[3])
    }
}
