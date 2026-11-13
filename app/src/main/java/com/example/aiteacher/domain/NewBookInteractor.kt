package com.example.aiteacher.domain

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import com.example.aiteacher.model.Book
import com.example.aiteacher.model.Utility.mapBookToBookEntity
import com.example.aiteacher.presentation.newbook.model.BookMetadata
import com.example.aiteacher.repository.NewBookRepository
import com.example.aiteacher.repository.RequestRepository

class NewBookInteractor(
    val repository: NewBookRepository,
    val requestRepository: RequestRepository) {
    fun readPdf(uri: Uri, context: Context) : BookMetadata {
        return repository.readPdf(uri, context)
    }

    fun savePdf(uri: Uri, context : Context, size : Long, onProgress : (Float) -> Unit){
        return repository.savePdf(uri, context, size, onProgress)
    }

    suspend fun askLlm(userRequest : String, uri: Uri, contentResolver : ContentResolver) {
        requestRepository.apiRequest(userRequest, uri, contentResolver)
    }

    suspend fun saveBook(book: Book) {
        repository.saveBook(mapBookToBookEntity(book))
    }
}