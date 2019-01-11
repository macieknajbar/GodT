package com.gmail.najbar.maciek.godt

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.inputmethod.EditorInfo
import com.gmail.najbar.maciek.godt.details.RecipeDetailsActivity
import com.gmail.najbar.maciek.godt.presenter.LoadRecipesPresenter
import com.gmail.najbar.maciek.godt.presenter.PickRecipePresenter
import com.gmail.najbar.maciek.godt.presenter.SearchForRecipesPresenter
import com.gmail.najbar.maciek.repository.cache.LoadRecipesCache
import com.gmail.najbar.maciek.repository.cache.SearchForRecipesGateway
import com.gmail.najbar.maciek.usecase.LoadRecipes
import com.gmail.najbar.maciek.usecase.LoadRecipesImpl
import com.gmail.najbar.maciek.usecase.PickRecipe
import com.gmail.najbar.maciek.usecase.PickRecipeImpl
import com.gmail.najbar.maciek.usecase.SearchForRecipes
import com.gmail.najbar.maciek.usecase.SearchForRecipesImpl
import kotlinx.android.synthetic.main.activity_main.progressBar
import kotlinx.android.synthetic.main.activity_main.recipes
import kotlinx.android.synthetic.main.activity_main.searchBox

class RecipesActivity : AppCompatActivity(),
        RecipesContract.LoadRecipesView,
        RecipesContract.PickRecipeView,
        RecipesContract.SearchForRecipesView {

    private val loadRecipes: LoadRecipes =
            LoadRecipesImpl(
                    Gateways.loadRecipesGateway(),
                    LoadRecipesCache(),
                    LoadRecipesPresenter(this))

    private val pickRecipe: PickRecipe =
            PickRecipeImpl(PickRecipePresenter(this))

    private val searchForRecipes: SearchForRecipes =
            SearchForRecipesImpl(
                    SearchForRecipesGateway(),
                    SearchForRecipesPresenter(this))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchBox.setOnEditorActionListener { v, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                searchForRecipes.searchByIngredient(v.text.toString())
                return@setOnEditorActionListener true
            }

            return@setOnEditorActionListener false
        }

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

    override fun displayFiltered(recipes: Collection<RecipesContract.Recipe>) {

    }
}
