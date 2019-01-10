package com.gmail.najbar.maciek.godt

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

class RecipesAdapter(private val recipes: Collection<RecipesContract.Recipe>) : RecyclerView.Adapter<RecipesAdapter.RecipeHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: RecipeHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class RecipeHolder(view: View): RecyclerView.ViewHolder(view)
}