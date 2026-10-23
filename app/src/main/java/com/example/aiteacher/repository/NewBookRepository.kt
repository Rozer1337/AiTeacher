package com.example.aiteacher.repository

import android.content.Context
import android.graphics.pdf.PdfRenderer
import android.net.Uri
import android.provider.OpenableColumns
import com.example.aiteacher.presentation.newbook.model.BookMetadata

class NewBookRepository {
    fun readPdf(uri: Uri, context: Context) : BookMetadata {
        var name = ""
        var size : Long = 0
        context.contentResolver.query(
            uri,
            arrayOf(OpenableColumns.DISPLAY_NAME, OpenableColumns.SIZE),
            null, null, null,
        )?.use { cursor ->
            if (cursor.moveToFirst()) {
                val nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                val sizeIndex = cursor.getColumnIndex(OpenableColumns.SIZE)
                if (nameIndex != -1) name = cursor.getString(nameIndex) ?: name
                if (sizeIndex != -1) size = cursor.getLong(sizeIndex)
            }
        }
        val pages = try {
            context.contentResolver.openFileDescriptor(uri, "r")?.use { fd ->
                PdfRenderer(fd).use { it.pageCount }
            } ?: 0
        } catch (e: Exception) {
            0
        }
        return BookMetadata(name, size, pages)
    }

    fun savePdf(uri: Uri) {

    }
}