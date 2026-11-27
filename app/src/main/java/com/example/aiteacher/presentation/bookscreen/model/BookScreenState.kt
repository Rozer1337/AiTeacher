package com.example.aiteacher.presentation.bookscreen.model

import com.example.aiteacher.model.Constants

data class BookScreenState(
    val name : String = Constants.EMPTY_STRING,
    val paragraphCount : Int = Constants.ZERO_INT,
    val subject : String = Constants.EMPTY_STRING,
    val grade : String = Constants.EMPTY_STRING,
    val pageCount : Int = Constants.ZERO_INT,
    val chatCount : Int = Constants.ZERO_INT,
)
