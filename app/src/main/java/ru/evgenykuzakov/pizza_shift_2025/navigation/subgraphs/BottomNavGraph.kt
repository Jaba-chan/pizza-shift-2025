package ru.evgenykuzakov.pizza_shift_2025.navigation.subgraphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.evgenykuzakov.pizza_shift_2025.navigation.Screen

fun NavGraphBuilder.bottomNavGraph(
    pizzaCatalogScreenContent: @Composable () -> Unit,
    pizzaDetailScreenContent: @Composable () -> Unit,
    ordersScreenContent: @Composable () -> Unit,
    cartScreenContent: @Composable () -> Unit,
    profileScreenContent: @Composable () -> Unit
){
    navigation(
        startDestination = Screen.PizzaScreen.route,
        route = Screen.HomeScreen.route
    ){
        pizzaNavGraph(
            catalogContent = pizzaCatalogScreenContent,
            detailScreenContent = pizzaDetailScreenContent
        )
        composable(Screen.OrdersScreen.route) {
            ordersScreenContent()
        }
        cartNavGraph(
            cartScreenContent = cartScreenContent
        )
        composable(Screen.ProfileScreen.route) {
            profileScreenContent()
        }
    }
}