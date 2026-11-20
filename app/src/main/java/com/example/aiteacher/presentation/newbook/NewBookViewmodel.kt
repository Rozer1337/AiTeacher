package com.example.aiteacher.presentation.newbook

import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aiteacher.domain.NewBookInteractor
import com.example.aiteacher.model.Book
import com.example.aiteacher.presentation.newbook.model.NewBookScreenState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewBookViewmodel(val interactor: NewBookInteractor) : ViewModel() {

    private val _bookMetadata = MutableStateFlow(NewBookScreenState())
    val bookMetadata = _bookMetadata.asStateFlow()

    fun pdfUpload(uri: Uri, context: Context) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val state = interactor.readPdf(uri, context)
                _bookMetadata.update {
                    it.copy(
                        fileName = state.name,
                        size = state.size,
                        pages = state.pages
                    )
                }
                interactor.savePdf(uri, context, bookMetadata.value.size){ progress ->
                    _bookMetadata.update {
                        it.copy(
                            progress = progress
                        )
                    }
                }
                interactor.askLlm("Сколько страниц", uri, context.contentResolver)
                val book = Book(
                    grade = bookMetadata.value.grade,
                    name = bookMetadata.value.name,
                    paragraphs = 1,
                    chatsCount = 1,
                    subject = bookMetadata.value.subject
                )
                interactor.saveBook(book)
            }
        }
    }

    fun onGradeTextFieldUpdated(text : String) {
        _bookMetadata.update {
            it.copy(
                grade = text
            )
        }
    }

    fun onSubjectTextFieldUpdated(text : String) {
        _bookMetadata.update {
            it.copy(
                subject = text
            )
        }
    }

    fun onNameTextFieldUpdated(text : String) {
        _bookMetadata.update {
            it.copy(
                name = text
            )
        }
    }
}

//Отображение сохранееных книг, переход на экран с чатами (сделать верстку)