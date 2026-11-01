package com.example.aiteacher.di

import com.example.aiteacher.domain.NewBookInteractor
import com.example.aiteacher.presentation.newbook.NewBookViewmodel
import com.example.aiteacher.repository.NewBookRepository
import com.example.aiteacher.repository.RequestRepository
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
val appModule = module {
    single <NewBookRepository> { NewBookRepository() }

    single <RequestRepository> { RequestRepository() }

    single <NewBookInteractor> { NewBookInteractor(get(), get()) }

    viewModel <NewBookViewmodel> { NewBookViewmodel(get()) }
}