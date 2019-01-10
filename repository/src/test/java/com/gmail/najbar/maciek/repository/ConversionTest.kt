package com.gmail.najbar.maciek.repository

import com.google.gson.Gson
import org.junit.Assert.assertEquals
import org.junit.Test

class ConversionTest {

    @Test fun `converts recipe correctly`() {
        val recipe = Gson().fromJson(json, Recipe::class.java)

        assertEquals(TITLE, recipe.title)
        assertEquals(DESCRIPTION, recipe.description)
        assertEquals(RECIPE_ID, recipe.id)
        assertEquals(INGREDIENT_ID_1, recipe.ingredients.first().elements.first().id)
        assertEquals(INGREDIENT_NAME_1, recipe.ingredients.first().elements.first().name)
        assertEquals(INGREDIENT_ID_2, recipe.ingredients.first().elements.last().id)
        assertEquals(INGREDIENT_NAME_2, recipe.ingredients.first().elements.last().name)
        assertEquals(IMAGE_URL, recipe.images.first().url)
    }

    private val json = "{\"title\":\"$TITLE\",\"description\":\"$DESCRIPTION\",\"id\":$RECIPE_ID,\"ingredients\":[{\"elements\":[{\"id\":$INGREDIENT_ID_1,\"name\":\"$INGREDIENT_NAME_1\"},{\"id\":$INGREDIENT_ID_2,\"name\":\"$INGREDIENT_NAME_2\"}]}],\"images\":[{\"url\":\"$IMAGE_URL\"}]  }"

    companion object {
        const val TITLE = "Some title"
        const val DESCRIPTION = "Some description"
        const val RECIPE_ID = 1234
        const val INGREDIENT_ID_1 = 1
        const val INGREDIENT_NAME_1 = "Ingredient name 1"
        const val INGREDIENT_ID_2 = 2
        const val INGREDIENT_NAME_2 = "Ingredient name 2"
        const val IMAGE_URL = "http://some_url.html"
    }
}