package com.example.aiteacher.app

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.example.aiteacher.presentation.mainscreen.MainScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.aiteacher.presentation.newbook.NewBookScreen

@Composable
fun AppNavigation(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = MainScreenRoute
    ) {
        composable<MainScreenRoute> {
            MainScreen(
                listOfBooks = listOf(),
                onAddBookClick = {
                    navHostController.navigate(NewBookScreenRoute)
                }
            )
        }

        composable<NewBookScreenRoute> {
            NewBookScreen()
        }
    }
}
