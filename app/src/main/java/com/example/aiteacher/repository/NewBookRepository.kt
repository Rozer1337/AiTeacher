package com.example.aiteacher.repository

import android.content.Context
import android.graphics.pdf.PdfRenderer
import android.net.Uri
import android.provider.OpenableColumns
import com.example.aiteacher.presentation.newbook.model.BookMetadata
import java.io.File
import java.util.UUID

class NewBookRepository {
    fun readPdf(uri: Uri, context: Context): BookMetadata {
        var name = ""
        var size: Long = 0
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

    fun savePdf(uri: Uri, context : Context, size : Long, onProgress : (Float) -> Unit) {
        val dir = File(context.filesDir, "books").apply { mkdirs() }
        val target = File(dir, "${UUID.randomUUID()}.pdf")
        context.contentResolver.openInputStream(uri)!!.use { input ->
            target.outputStream().use { output ->
                val buffer = ByteArray(64 * 1024)
                var copied = 0L
                while (true) {
                    val read = input.read(buffer)
                    if (read == -1) break
                    output . write (buffer, 0, read)
                    copied += read
                    if (size > 0) onProgress(copied.toFloat() / size)
                }
            }
        }
    }
}