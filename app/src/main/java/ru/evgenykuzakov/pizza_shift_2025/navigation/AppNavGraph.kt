package ru.evgenykuzakov.pizza_shift_2025.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.evgenykuzakov.pizza_shift_2025.navigation.subgraphs.bottomNavGraph

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    authScreenContent: @Composable () -> Unit,
    pizzaCatalogScreenContent: @Composable () -> Unit,
    pizzaDetailScreenContent: @Composable () -> Unit,
    pizzaEditScreenContent: @Composable () -> Unit,
    cartScreenContent: @Composable () -> Unit,
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.AuthScreen.route

    ) {
        composable(Screen.AuthScreen.route) {
            authScreenContent()
        }
        bottomNavGraph(
            pizzaCatalogScreenContent = pizzaCatalogScreenContent,
            pizzaDetailScreenContent = pizzaDetailScreenContent,
            pizzaEditScreenContent = pizzaEditScreenContent,
            ordersScreenContent = {},
            cartScreenContent = cartScreenContent,
            profileScreenContent = {}
        )
    }
}