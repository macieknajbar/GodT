package com.gmail.najbar.maciek.godt.page

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.pressImeActionButton
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.doesNotExist
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.hasDescendant
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import com.gmail.najbar.maciek.godt.R
import com.gmail.najbar.maciek.godt.RecipesAdapter
import com.gmail.najbar.maciek.godt.RecipesContract

object RecipesPage {

    fun scrollTo(recipe: RecipesContract.Recipe) {
        onView(withId(R.id.recipes))
                .perform(RecyclerViewActions.scrollTo<RecipesAdapter.RecipeHolder>(hasDescendant(withText(recipe.title))))
    }

    fun enter(recipe: RecipesContract.Recipe) {
        onView(withText(recipe.title))
                .perform(click())
    }

    fun confirmDisplayed(desiredRecipe: RecipesContract.Recipe) {
        onView(withText(desiredRecipe.title))
                .check(matches(isDisplayed()))

        onView(withText(desiredRecipe.description))
                .check(matches(isDisplayed()))

        onView(withText(R.string.details_ingredientsLabel))
                .check(matches(isDisplayed()))

        onView(withText(desiredRecipe.ingredients.joinToString { "* $it\n" }))
                .check(matches(isDisplayed()))
    }

    fun searchFor(eggIngredient: String) {
        onView(withId(R.id.search_bar))
                .perform(typeText(eggIngredient), pressImeActionButton())
    }

    fun cannotSee(recipe: RecipesContract.Recipe) {
        onView(withText(recipe.title))
                .check(doesNotExist())
    }
}