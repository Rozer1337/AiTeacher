package com.example.aiteacher.repository

import android.content.ContentResolver
import android.net.Uri
import com.example.aiteacher.model.Utility.uriToBase64
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONObject

class RequestRepository() {
    private val client = OkHttpClient.Builder().build()
    private val apiKey = ""

    suspend fun apiRequest(userRequest : String, uri: Uri, contentResolver: ContentResolver) {
        withContext(Dispatchers.IO) {
            val base64 = uriToBase64(uri, contentResolver)

            val model = "z-ai/glm-5.3-flash"
            val engine = "cloudflare-ai"

            val content = JSONArray()
                .put(
                JSONObject()
                    .put("type", "text")
                    .put("text", userRequest)
                )
                .put(
                    JSONObject()
                        .put("type", "file")
                        .put("file", JSONObject()
                            .put("filename", "document.pdf")
                            .put("file_data", "data:application/pdf;base64,$base64"))
                )
            val message = JSONObject()
                .put("role", "user")
                .put("content", content)

            val plugins = JSONArray()
                .put(
                    JSONObject()
                        .put("id", "file-parser")
                        .put("pdf", JSONObject()
                            .put("engine", engine)
                        )
                )

            val json = JSONObject()
                .put("model", model)
                .put("messages", JSONArray().put(message))
                .put("plugins", plugins)

            val request = Request.Builder()
                .url("https://openrouter.ai/api/v1/chat/completions")
                .header("Authorization", "Bearer $apiKey")
                .post(json.toString().toRequestBody("application/json".toMediaType()))
                .build()

            client.newCall(request).execute().use{ response ->
                println(response)
                println(response.body.string())
            }
        }
    }
}
