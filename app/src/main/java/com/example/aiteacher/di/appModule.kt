package com.example.aiteacher.di

import com.example.aiteacher.domain.NewBookInteractor
import com.example.aiteacher.presentation.newbook.NewBookViewmodel
import com.example.aiteacher.repository.NewBookRepository
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import org.koin.plugin.module.dsl.viewModel

val appModule = module {
    single <NewBookRepository> { NewBookRepository() }

    single <NewBookInteractor> { NewBookInteractor(get()) }

    viewModel <NewBookViewmodel> { NewBookViewmodel(get()) }
}