package ru.evgenykuzakov.pizza_shift_2025.navigation

sealed class Screen(
    val route: String
) {
    data object AuthScreen: Screen(ROUTE_AUTH)
    data object HomeScreen: Screen(ROUTE_HOME)

    data object PizzaScreen: Screen(BASE_ROUTE_PIZZA)
    data object PizzaCatalogScreen: Screen(ROUTE_PIZZA_CATALOG)
    data object PizzaDetailScreen: Screen(ROUTE_PIZZA_DETAIL){
        fun createRoute(pizzaId: String): String {
            return "$ROUTE_PIZZA_CATALOG?pizzaId=$pizzaId"
        }
    }
    data object PizzaEditScreen: Screen(ROUTE_PIZZA_EDIT){
        fun createRoute(editId: Long): String{
            return "$ROUTE_PIZZA_CATALOG/edit?editId=$editId"
        }
    }

    data object OrdersScreen: Screen(BASE_ROUTE_ORDER)

    data object CartHomeScreen: Screen(BASE_ROUTE_CART_HOME)
    data object CartScreen: Screen(ROUTE_CART)
    data object PaymentScreen: Screen(ROUTE_CART_PAYMENT)

    data object ProfileScreen: Screen(BASE_ROUTE_PROFILE)

    companion object {
        private const val ROUTE_AUTH = "auth"
        private const val ROUTE_HOME = "home"
        private const val BASE_ROUTE_PIZZA = "pizza"
        private const val ROUTE_PIZZA_CATALOG = "$BASE_ROUTE_PIZZA/catalog"
        private const val ROUTE_PIZZA_DETAIL = "$ROUTE_PIZZA_CATALOG?pizzaId={pizzaId}"
        private const val ROUTE_PIZZA_EDIT = "$ROUTE_PIZZA_CATALOG/edit?editId={editId}"
        private const val BASE_ROUTE_ORDER= "order"
        private const val BASE_ROUTE_CART_HOME = "cart"
        private const val ROUTE_CART= "$BASE_ROUTE_CART_HOME/total"
        private const val ROUTE_CART_PAYMENT= "$BASE_ROUTE_CART_HOME/payment"
        private const val BASE_ROUTE_PROFILE= "profile"
    }
}