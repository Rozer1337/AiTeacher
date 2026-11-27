package com.example.aiteacher.repository

import com.example.aiteacher.database.BookDao
import com.example.aiteacher.database.BookEntity

class BookRepository(
    private val dao: BookDao
) {
    fun getBookById(bookId : Int) : BookEntity {
        return dao.getById(bookId)
    }
}