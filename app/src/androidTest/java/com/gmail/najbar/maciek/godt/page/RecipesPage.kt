package com.gmail.najbar.maciek.godt.page

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import com.gmail.najbar.maciek.godt.R
import com.gmail.najbar.maciek.godt.RecipesAdapter

object RecipesPage {

    fun scrollTo(title: String) {
        onView(withId(R.id.recipes))
                .perform(RecyclerViewActions.scrollTo<RecipesAdapter.RecipeHolder>(withText(title)))
    }
}