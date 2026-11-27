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
            id = book.id,
            grade = book.grade,
            name = book.name,
            paragraphCount = book.paragraphCount,
            subject = book.subject,
            chatCount = book.chatCount,
            pageCount = book.pageCount
        )
    }

    fun mapEntityBookToBook(bookEntity: BookEntity) : Book {
        return Book(
            id = bookEntity.id,
            grade = bookEntity.grade,
            name = bookEntity.name,
            paragraphCount = bookEntity.paragraphCount,
            chatCount = bookEntity.chatCount,
            pageCount = bookEntity.pageCount,
            subject = bookEntity.subject,
        )
    }
}