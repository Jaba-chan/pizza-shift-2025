package ru.evgenykuzakov.pizza_shift_2025.navigation.subgraphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.evgenykuzakov.pizza_shift_2025.navigation.Screen

fun NavGraphBuilder.pizzaNavGraph(
    catalogContent: @Composable () -> Unit,
    detailScreenContent: @Composable () -> Unit,
){
    navigation(
        startDestination = Screen.PizzaCatalogScreen.route,
        route = Screen.PizzaScreen.route
    ) {
        composable(Screen.PizzaCatalogScreen.route) {
            catalogContent()
        }
        composable(Screen.PizzaDetailScreen.route) {
            detailScreenContent()
        }
    }
}