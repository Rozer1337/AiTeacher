package com.example.aiteacher.repository

import com.example.aiteacher.database.BookDao
import com.example.aiteacher.model.Book
import com.example.aiteacher.model.Utility.mapEntityBookToBook
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MainRepository(private val dao: BookDao) {
    suspend fun getAllBooks() : Flow<List<Book>> {
        return dao.getAll().map { it.map { mapEntityBookToBook(it) } }
    }
}