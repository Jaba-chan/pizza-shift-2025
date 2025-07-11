package ru.evgenykuzakov.pizza_shift_2025.navigation.subgraphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.evgenykuzakov.pizza_shift_2025.navigation.Screen

fun NavGraphBuilder.profileNavGraph(
    showProfileScreenContent: @Composable () -> Unit
){
    navigation(
        startDestination = Screen.ShowProfileScreen.route,
        route = Screen.ProfileScreen.route
    ) {
        composable(Screen.ShowProfileScreen.route) {
            showProfileScreenContent()
        }
    }
}