package com.gmail.najbar.maciek.godt

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class RecipesAdapter(private val recipes: Collection<RecipesContract.Recipe>) : RecyclerView.Adapter<RecipesAdapter.RecipeHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeHolder =
            RecipeHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false))

    override fun getItemCount(): Int = recipes.size

    override fun onBindViewHolder(holder: RecipeHolder, position: Int) {
        val recipe = recipes.elementAt(position)

        holder.title.text = recipe.title
        holder.description.text = recipe.description
        recipe.imageUrl?.let { Glide.with(holder.itemView.context).asDrawable().load(Uri.parse(it)).into(holder.image) }
    }

    class RecipeHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.item_recipeTitle)!!
        val description = view.findViewById<TextView>(R.id.item_recipeDescription)!!
        val image = view.findViewById<ImageView>(R.id.item_recipeImage)!!
    }
}