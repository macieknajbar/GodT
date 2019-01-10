package com.gmail.najbar.maciek.godt

interface RecipesContract {
    data class Recipe(val id: Long, val title: String, val description: String, val ingredients: Collection<String>, val imageUrl: String?)
}