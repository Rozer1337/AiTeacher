package com.example.aiteacher.presentation.newbook.model

data class NewBookScreenState(
    val fileName : String = "",
    val name : String = "",
    val size : Long = 0,
    val pages : Int = 0,
    val progress : Float = 0F,
    val grade : String = "",
    val subject : String = ""
)
