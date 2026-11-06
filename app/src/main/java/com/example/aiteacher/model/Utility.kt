package com.example.aiteacher.model

import android.content.ContentResolver
import android.net.Uri

object Utility {
    fun byteToMByte(byte : Long) : Long {
        return (byte / 1048576)
    }

    fun uriToBase64(uri: Uri, contentResolver: ContentResolver) : String {
        val bytes = contentResolver.openInputStream(uri)?.use {
            it.readBytes()
        }
        val base64 = android.util.Base64.encodeToString(bytes, android.util.Base64.NO_WRAP)
        return base64
    }
}