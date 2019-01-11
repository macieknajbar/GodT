package com.gmail.najbar.maciek.godt.details

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.gmail.najbar.maciek.godt.R
import com.gmail.najbar.maciek.godt.details.presenter.DisplayDetailsPresenter
import com.gmail.najbar.maciek.repository.cache.DisplayDetailsGateway
import com.gmail.najbar.maciek.usecase.DisplayDetails
import com.gmail.najbar.maciek.usecase.DisplayDetailsImpl
import kotlinx.android.synthetic.main.activity_recipe_details.details_recipeDescription
import kotlinx.android.synthetic.main.activity_recipe_details.details_recipeImage
import kotlinx.android.synthetic.main.activity_recipe_details.details_recipeIngredients
import kotlinx.android.synthetic.main.activity_recipe_details.details_recipeTitle

class RecipeDetailsActivity : AppCompatActivity(),
        RecipeDetailsContract.DisplayDetailsView {

    private val displayDetails: DisplayDetails =
            DisplayDetailsImpl(
                    DisplayDetailsGateway(),
                    DisplayDetailsPresenter(this))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_details)

        displayDetails.of(intent.getLongExtra(EXTRA_RECIPE_ID, -1))
    }

    override fun displayDetailsOf(recipe: DisplayDetails.Recipe) {
        details_recipeTitle.text = recipe.title
        details_recipeDescription.text = recipe.description
        details_recipeIngredients.text = recipe.ingredients.joinToString { "* $it\n" }
        recipe.imageUrl?.let {
            Glide.with(this).asDrawable().load(Uri.parse(it)).into(details_recipeImage)
        }
    }

    companion object {
        const val EXTRA_RECIPE_ID = "EXTRA_RECIPE_ID"
    }
}