package com.gmail.najbar.maciek.godt.details

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gmail.najbar.maciek.godt.R
import com.gmail.najbar.maciek.godt.details.presenter.DisplayDetailsPresenter
import com.gmail.najbar.maciek.repository.cache.DisplayDetailsGateway
import com.gmail.najbar.maciek.usecase.DisplayDetails
import com.gmail.najbar.maciek.usecase.DisplayDetailsImpl

class RecipeDetailsActivity : AppCompatActivity(),
        RecipeDetailsContract.DisplayDetailsView {

    private val displayDetails: DisplayDetails =
            DisplayDetailsImpl(
                    DisplayDetailsGateway(),
                    DisplayDetailsPresenter(this))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_details)
    }

    override fun displayDetailsOf(recipe: DisplayDetails.Recipe) {

    }

    companion object {
        const val EXTRA_RECIPE_ID = "EXTRA_RECIPE_ID"
    }
}