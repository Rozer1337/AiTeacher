package com.example.aiteacher.presentation.bookscreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.aiteacher.app.BookScreenRoute
import com.example.aiteacher.domain.BookInteractor
import com.example.aiteacher.presentation.bookscreen.model.BookScreenState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BookViewmodel(
    val bookInteractor: BookInteractor,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = MutableStateFlow(BookScreenState())
    val state = _state.asStateFlow()
    private val bookId = savedStateHandle.toRoute<BookScreenRoute>().bookId

    init {
        getBookById(bookId)
    }

    fun getBookById(bookId : Int) {
        viewModelScope.launch {
            val book = withContext(Dispatchers.IO) {
                bookInteractor.getBookById(bookId)
            }
            _state.update {
                it.copy(
                    name = book.name,
                    paragraphCount = book.paragraphCount,
                    grade = book.grade,
                    subject = book.subject,
                    pageCount = book.pageCount,
                    chatCount = book.chatCount
                )
            }
        }
    }
}