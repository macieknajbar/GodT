package com.gmail.najbar.maciek.domain

data class Ingredient private constructor(val id: Long, val name: String) {

    companion object {
        fun from(id: Long, name: String) =
                Ingredient(id, name)
    }
}