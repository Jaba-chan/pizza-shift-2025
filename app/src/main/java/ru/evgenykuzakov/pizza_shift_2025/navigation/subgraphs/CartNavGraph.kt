package ru.evgenykuzakov.pizza_shift_2025.navigation.subgraphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import ru.evgenykuzakov.pizza_shift_2025.navigation.Screen

fun NavGraphBuilder.cartNavGraph(
    cartScreenContent: @Composable () -> Unit,
    paymentScreenContent: @Composable () -> Unit,
){
    navigation(
        startDestination = Screen.CartScreen.route,
        route = Screen.CartHomeScreen.route
    ) {
        composable(Screen.CartScreen.route) {
            cartScreenContent()
        }
        composable(Screen.PaymentScreen.route) {
            paymentScreenContent()
        }
    }
}