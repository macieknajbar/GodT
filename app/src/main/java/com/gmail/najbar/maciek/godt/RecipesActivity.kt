package com.gmail.najbar.maciek.godt

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.gmail.najbar.maciek.godt.details.RecipeDetailsActivity
import com.gmail.najbar.maciek.godt.presenter.LoadRecipesPresenter
import com.gmail.najbar.maciek.godt.presenter.PickRecipePresenter
import com.gmail.najbar.maciek.repository.cache.LoadRecipesCache
import com.gmail.najbar.maciek.usecase.LoadRecipes
import com.gmail.najbar.maciek.usecase.LoadRecipesImpl
import com.gmail.najbar.maciek.usecase.PickRecipe
import com.gmail.najbar.maciek.usecase.PickRecipeImpl
import kotlinx.android.synthetic.main.activity_main.progressBar
import kotlinx.android.synthetic.main.activity_main.recipes

class RecipesActivity : AppCompatActivity(),
        RecipesContract.LoadRecipesView,
        RecipesContract.PickRecipeView {

    private val loadRecipes: LoadRecipes =
            LoadRecipesImpl(
                    Gateways.loadRecipesGateway(),
                    LoadRecipesCache(),
                    LoadRecipesPresenter(this))

    private val pickRecipe: PickRecipe =
            PickRecipeImpl(PickRecipePresenter(this))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recipes.layoutManager = LinearLayoutManager(this)
    }

    override fun onStart() {
        super.onStart()
        loadRecipes.all()
    }

    override fun displayRecipes(recipes: Collection<RecipesContract.Recipe>) {
        progressBar.visibility = View.GONE
        this.recipes.adapter = RecipesAdapter(recipes, View.OnClickListener { view ->
            val recipe = view.tag as RecipesContract.Recipe
            pickRecipe.withId(recipe.id)
        })
    }

    override fun displayDetailsFor(recipeId: Long) {
        startActivity(Intent(this, RecipeDetailsActivity::class.java).putExtra(RecipeDetailsActivity.EXTRA_RECIPE_ID, recipeId))
    }
}
