package com.gmail.najbar.maciek.domain

data class Recipe(
        val id: Long,
        val title: String,
        val description: String,
        val ingredients: Collection<Ingredient>,
        val image: Image)