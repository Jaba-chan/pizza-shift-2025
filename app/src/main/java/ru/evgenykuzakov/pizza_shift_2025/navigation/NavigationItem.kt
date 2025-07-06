package ru.evgenykuzakov.pizza_shift_2025.navigation

import ru.evgenykuzakov.pizza_shift_2025.R

sealed class NavigationItem(
    val screen: Screen,
    val titleResId: Int,
    val iconResId: Int
) {
    data object Pizza: NavigationItem(
        screen = Screen.PizzaScreen,
        titleResId = R.string.pizza,
        iconResId = R.drawable.ic_pizza

    )
    data object Order: NavigationItem(
        screen = Screen.OrdersScreen,
        titleResId = R.string.orders,
        iconResId = R.drawable.ic_order

    )
    data object Cart: NavigationItem(
        screen = Screen.CartScreen,
        titleResId = R.string.cart,
        iconResId = R.drawable.ic_cart

    )
    data object Profile: NavigationItem(
        screen = Screen.ProfileScreen,
        titleResId = R.string.profile,
        iconResId = R.drawable.ic_profile

    )
}