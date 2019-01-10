package com.gmail.najbar.maciek.godt

import android.support.test.InstrumentationRegistry
import android.support.test.rule.ActivityTestRule

import org.junit.Rule
import org.junit.Test

import org.junit.Assert.*

class RecipesActivityTest {

    @get:Rule val rule = ActivityTestRule<RecipesActivity>(RecipesActivity::class.java, false, false)

    @Test fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()

        assertEquals("com.gmail.najbar.maciek.godt", appContext.packageName)
    }
}
