package com.gmail.najbar.maciek.godt

import android.content.Intent
import android.support.test.rule.ActivityTestRule
import com.gmail.najbar.maciek.godt.fake.RecipesResponse
import com.gmail.najbar.maciek.godt.page.RecipesPage
import org.junit.Rule
import org.junit.Test

class RecipesActivityTest {

    @get:Rule val rule = ActivityTestRule<RecipesActivity>(RecipesActivity::class.java, false, false)

    @Test fun scrollsThroughRecipes() {
        rule.launchActivity(Intent())

        RecipesPage.scrollTo(RecipesResponse.TITLE_3)
    }
}
