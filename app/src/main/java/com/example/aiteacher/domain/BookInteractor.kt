package com.example.aiteacher.domain

import com.example.aiteacher.model.Book
import com.example.aiteacher.model.Utility.mapEntityBookToBook
import com.example.aiteacher.repository.BookRepository

class BookInteractor(
    private val bookRepository : BookRepository
) {
    fun getBookById(bookId : Int) : Book {
        return mapEntityBookToBook(bookRepository.getBookById(bookId))
    }
}