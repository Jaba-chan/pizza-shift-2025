package ru.evgenykuzakov.pizza_shift_2025.navigation

sealed class Screen(
    val route: String
) {
    data object AuthScreen: Screen(ROUTE_AUTH)
    data object HomeScreen: Screen(ROUTE_HOME)

    data object PizzaScreen: Screen(BASE_ROUTE_PIZZA)
    data object PizzaCatalogScreen: Screen(ROUTE_PIZZA_CATALOG)
    data object PizzaDetailScreen: Screen(ROUTE_PIZZA_DETAIL){
        fun createRoute(pizzaId: String): String{
            return "$ROUTE_PIZZA_DETAIL?pizzaID=${pizzaId}"
        }
    }

    data object OrdersScreen: Screen(BASE_ROUTE_ORDER)

    data object CartScreen: Screen(BASE_ROUTE_CART)

    data object ProfileScreen: Screen(BASE_ROUTE_PROFILE)

    companion object {
        private const val ROUTE_AUTH = "auth"
        private const val ROUTE_HOME = "home"
        private const val BASE_ROUTE_PIZZA = "pizza"
        private const val ROUTE_PIZZA_CATALOG = "${BASE_ROUTE_PIZZA}/catalog"
        private const val ROUTE_PIZZA_DETAIL = "${BASE_ROUTE_PIZZA}/catalog?pizzaId={pizzaId}"
        private const val BASE_ROUTE_ORDER= "order"
        private const val BASE_ROUTE_CART= "cart"
        private const val BASE_ROUTE_PROFILE= "profile"
    }
}