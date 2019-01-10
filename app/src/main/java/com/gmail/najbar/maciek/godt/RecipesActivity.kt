package com.gmail.najbar.maciek.godt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.gmail.najbar.maciek.repository.cache.LoadRecipesCache
import com.gmail.najbar.maciek.repository.gateway.RetrofitLoadRecipesGateway
import com.gmail.najbar.maciek.usecase.LoadRecipes
import com.gmail.najbar.maciek.usecase.LoadRecipesImpl
import kotlinx.android.synthetic.main.activity_main.recipes
import java.lang.StringBuilder

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

        loadRecipes.all()
    }

    override fun displayRecipes(recipes: Collection<RecipesContract.Recipe>) {
        val stringBuilder = StringBuilder()

        for (recipe in recipes) {
            stringBuilder.appendln("Id: ${recipe.id}")
            stringBuilder.appendln("Title: ${recipe.title}")
            stringBuilder.appendln("Description: ${recipe.description}")
            stringBuilder.appendln("Ingredients:")
            for (ingredient in recipe.ingredients) {
                stringBuilder.appendln("\t* $ingredient")
            }
            stringBuilder.appendln("Image: ${recipe.imageUrl}")
        }

        this.recipes.text = stringBuilder.toString()
    }
}
