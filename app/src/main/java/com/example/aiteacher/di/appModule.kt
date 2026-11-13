package com.example.aiteacher.di

import androidx.room3.Room
import com.example.aiteacher.database.BookDao
import com.example.aiteacher.database.BookDatabase
import com.example.aiteacher.domain.MainInteractor
import com.example.aiteacher.domain.NewBookInteractor
import com.example.aiteacher.presentation.mainscreen.MainViewmodel
import com.example.aiteacher.presentation.newbook.NewBookViewmodel
import com.example.aiteacher.repository.MainRepository
import com.example.aiteacher.repository.NewBookRepository
import com.example.aiteacher.repository.RequestRepository
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
val appModule = module {
    single <NewBookRepository> { NewBookRepository(get()) }

    single <RequestRepository> { RequestRepository() }

    single <NewBookInteractor> { NewBookInteractor(get(), get()) }

    viewModel <NewBookViewmodel> { NewBookViewmodel(get()) }

    single <BookDatabase> { Room.databaseBuilder(androidContext(), BookDatabase::class.java, "book_database").build() }
    single <BookDao> { get <BookDatabase>().bookDao() }

    single <MainRepository> { MainRepository(get()) }

    single <MainInteractor> { MainInteractor(get()) }

    viewModel <MainViewmodel> { MainViewmodel(get()) }
}