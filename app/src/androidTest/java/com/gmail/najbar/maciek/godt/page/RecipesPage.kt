package com.gmail.najbar.maciek.godt.page

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.hasDescendant
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
}