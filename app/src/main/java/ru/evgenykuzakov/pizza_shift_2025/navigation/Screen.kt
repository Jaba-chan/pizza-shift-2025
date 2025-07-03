package ru.evgenykuzakov.pizza_shift_2025.navigation

sealed class Screen(val route: String) {
    object AuthScreen: Screen(ROUTE_AUTH)

    companion object {
        private const val ROUTE_AUTH = "auth"
    }
}