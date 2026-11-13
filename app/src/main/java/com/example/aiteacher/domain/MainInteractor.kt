package com.example.aiteacher.domain

import com.example.aiteacher.model.Book
import com.example.aiteacher.repository.MainRepository
import kotlinx.coroutines.flow.Flow

class MainInteractor(
    val repository: MainRepository,
        )
{
    suspend fun getAllBooks() : Flow<List<Book>> {
        return repository.getAllBooks()
    }
}