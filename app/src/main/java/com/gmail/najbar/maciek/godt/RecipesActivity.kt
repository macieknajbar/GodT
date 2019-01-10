package com.gmail.najbar.maciek.godt

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.gmail.najbar.maciek.repository.cache.LoadRecipesCache
import com.gmail.najbar.maciek.repository.gateway.RetrofitLoadRecipesGateway
import com.gmail.najbar.maciek.usecase.LoadRecipes
import com.gmail.najbar.maciek.usecase.LoadRecipesImpl
import kotlinx.android.synthetic.main.activity_main.recipes

class RecipesActivity : AppCompatActivity(),
        RecipesContract.LoadRecipesView {

    private val loadRecipes: LoadRecipes =
            LoadRecipesImpl(
                    RetrofitLoadRecipesGateway(),
                    LoadRecipesCache(),
                    LoadRecipesPresenter(this))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recipes.layoutManager = LinearLayoutManager(this)

        loadRecipes.all()
    }

    override fun displayRecipes(recipes: Collection<RecipesContract.Recipe>) {
        this.recipes.adapter = RecipesAdapter(recipes)
    }
}
