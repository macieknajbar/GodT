package com.gmail.najbar.maciek.domain

data class Recipe private constructor(
        val id: Long,
        val title: String,
        val description: String,
        val ingredients: Collection<Ingredient>,
        val image: Image) {

    companion object {
        fun from(id: Long, title: String, description: String, imageUrl: String?, ingredients: Collection<Ingredient>) =
                Recipe(id, title, description, ingredients, Image.from(imageUrl))
    }
}