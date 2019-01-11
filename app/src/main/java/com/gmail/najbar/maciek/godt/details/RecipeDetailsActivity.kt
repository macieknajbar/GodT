package com.gmail.najbar.maciek.godt.details

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gmail.najbar.maciek.godt.R

class RecipeDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_details)
    }

    companion object {
        const val EXTRA_RECIPE_ID = "EXTRA_RECIPE_ID"
    }
}