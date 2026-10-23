package com.example.aiteacher.presentation.newbook

import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aiteacher.domain.NewBookInteractor
import com.example.aiteacher.presentation.newbook.model.NewBookScreenState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewBookViewmodel(val interactor: NewBookInteractor) : ViewModel() {

    private val _bookMetadata = MutableStateFlow<NewBookScreenState>(NewBookScreenState())
    val bookMetadata = _bookMetadata.asStateFlow()

    fun pdfUpload(uri: Uri, context: Context) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val state = interactor.readPdf(uri, context)
                _bookMetadata.update {
                    it.copy(
                        name = state.name,
                        size = state.size,
                        pages = state.pages
                    )
                }
            }
        }
    }
}