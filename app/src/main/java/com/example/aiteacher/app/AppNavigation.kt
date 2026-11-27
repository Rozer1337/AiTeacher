package com.example.aiteacher.app

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.aiteacher.presentation.bookscreen.BookScreen
import com.example.aiteacher.presentation.mainscreen.MainScreen
import com.example.aiteacher.presentation.newbook.NewBookScreen

@Composable
fun AppNavigation(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = MainScreenRoute
    ) {
        composable<MainScreenRoute> {
            MainScreen(
                onAddBookClick = {
                    navHostController.navigate(NewBookScreenRoute)
                } ,
                onBookClick = { bookId ->
                    navHostController.navigate(BookScreenRoute(bookId))
                }
            )
        }

        composable<NewBookScreenRoute> {
            NewBookScreen()
        }

        composable<BookScreenRoute> {
            val route = it.toRoute<BookScreenRoute>()
            BookScreen(route.bookId)
        }
    }
}
