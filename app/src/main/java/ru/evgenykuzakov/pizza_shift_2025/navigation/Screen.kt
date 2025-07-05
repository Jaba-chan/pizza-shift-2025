package ru.evgenykuzakov.pizza_shift_2025.navigation

sealed class Screen(val route: String) {
    object AuthScreen: Screen(ROUTE_AUTH)
    object CatalogScreen: Screen(ROUTE_CATALOG)

    companion object {
        private const val ROUTE_AUTH = "auth"
        private const val ROUTE_CATALOG = "catalog"
    }
}