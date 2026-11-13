package com.example.aiteacher.domain

import com.example.aiteacher.model.Book
import com.example.aiteacher.repository.MainRepository
import kotlinx.coroutines.flow.Flow

class MainInteractor(
    private val mainRepository: MainRepository,
) {
    suspend fun getAllBooks() : Flow<List<Book>> {
        return mainRepository.getAllBooks()
    }
}