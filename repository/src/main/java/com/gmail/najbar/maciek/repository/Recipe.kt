package com.gmail.najbar.maciek.repository

class Recipe {
    var id: Int = -1
    lateinit var title: String
    lateinit var description: String
    lateinit var ingredients: List<Ingredient>
    lateinit var images: List<Image>
}
