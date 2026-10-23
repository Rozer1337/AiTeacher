package com.example.aiteacher.domain

import android.content.Context
import android.net.Uri
import com.example.aiteacher.presentation.newbook.model.BookMetadata
import com.example.aiteacher.repository.NewBookRepository

class NewBookInteractor(val repository: NewBookRepository) {
    fun readPdf(uri: Uri, context: Context) : BookMetadata {
        return repository.readPdf(uri, context)
    }
}