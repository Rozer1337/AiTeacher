package com.example.aiteacher.model

data class Book(
    val id : Int = 0,
    val grade : String,
    val name : String,
    val paragraphCount : Int,
    val chatCount : Int,
    val subject : String,
    val pageCount : Int
)
