package com.example.aiteacher.presentation.mainscreen.model

import com.example.aiteacher.model.Book

data class MainScreenState(
    val books : List<Book> = emptyList()
)
