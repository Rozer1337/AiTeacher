package com.example.aiteacher.model

import android.content.ContentResolver
import android.net.Uri
import android.util.Base64
import com.example.aiteacher.database.BookEntity

object Utility {
    fun byteToMByte(byte : Long) : Long {
        return (byte / 1048576)
    }

    fun uriToBase64(uri: Uri, contentResolver: ContentResolver) : String {
        val bytes = contentResolver.openInputStream(uri)?.use {
            it.readBytes()
        }
        val base64 = Base64.encodeToString(bytes, Base64.NO_WRAP)
        return base64
    }

    fun mapBookToBookEntity(book: Book) : BookEntity {
        return BookEntity(
            grade = book.grade,
            name = book.name,
            paragraphs = book.paragraphs,
            chatsCount = book.chatsCount,
            subject = book.subject
        )
    }

    fun mapEntityBookToBook(bookEntity: BookEntity) : Book {
        return Book(
            grade = bookEntity.grade,
            name = bookEntity.name,
            paragraphs = bookEntity.paragraphs,
            chatsCount = bookEntity.chatsCount,
            subject = bookEntity.subject
        )
    }
}