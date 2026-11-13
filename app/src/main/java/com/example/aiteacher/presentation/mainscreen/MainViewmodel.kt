package com.example.aiteacher.presentation.mainscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aiteacher.domain.MainInteractor
import com.example.aiteacher.presentation.mainscreen.model.MainScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewmodel(val interactor: MainInteractor) : ViewModel() {
    private val _state = MutableStateFlow(MainScreenState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            interactor.getAllBooks().collect { books ->
                _state.update {
                    it.copy(
                        books = books
                    )
                }
            }
        }
    }
}