package ru.evgenykuzakov.pizza_shift_2025.navigation

import androidx.navigation.NavController

class NavigationState(
    private val navController: NavController
) {
    fun navigateToViaBottomBar(route: String){
        navController.navigate(route){
            popUpTo(Screen.HomeScreen.route){
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    fun navigateTo(route: String){
        navController.navigate(route){
            launchSingleTop = true
            restoreState = true
        }
    }
}