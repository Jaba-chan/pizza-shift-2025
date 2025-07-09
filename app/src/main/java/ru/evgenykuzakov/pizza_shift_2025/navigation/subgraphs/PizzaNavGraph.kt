package ru.evgenykuzakov.pizza_shift_2025.navigation.subgraphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import ru.evgenykuzakov.pizza_shift_2025.navigation.Screen

fun NavGraphBuilder.pizzaNavGraph(
    catalogContent: @Composable () -> Unit,
    detailScreenContent: @Composable () -> Unit,
    editScreenContent: @Composable () -> Unit,
){
    navigation(
        startDestination = Screen.PizzaCatalogScreen.route,
        route = Screen.PizzaScreen.route
    ) {
        composable(Screen.PizzaCatalogScreen.route) {
            catalogContent()
        }
        composable(
            route = Screen.PizzaDetailScreen.route,
            arguments = listOf( navArgument("pizzaId") {type = NavType.StringType})
        ) {
            detailScreenContent()
        }
        composable(
            route = Screen.PizzaEditScreen.route,
            arguments = listOf( navArgument("editId") {type = NavType.LongType})
        ) {
            editScreenContent()
        }
    }
}