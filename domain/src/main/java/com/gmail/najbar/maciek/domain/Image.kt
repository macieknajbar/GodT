package com.gmail.najbar.maciek.domain

data class Image private constructor(val url: String?) {

    companion object {
        fun from(url: String?) = Image(url)
    }
}