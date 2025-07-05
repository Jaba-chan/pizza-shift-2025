package ru.evgenykuzakov.pizza_shift_2025.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    authScreenContent: @Composable () -> Unit,
    catalogScreenContent: @Composable () -> Unit
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.AuthScreen.route

    ) {
        composable(Screen.AuthScreen.route) {
            authScreenContent()
        }
        composable(Screen.CatalogScreen.route) {
            catalogScreenContent()
        }
    }
}