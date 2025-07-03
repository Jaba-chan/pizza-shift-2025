package ru.evgenykuzakov.pizza_shift_2025.navigation

import androidx.navigation.NavController

class NavigationState(
    private val navController: NavController
) {
    fun navigateTo(route: String){
        navController.navigate(route){
            launchSingleTop = true
            restoreState = true
        }
    }
}