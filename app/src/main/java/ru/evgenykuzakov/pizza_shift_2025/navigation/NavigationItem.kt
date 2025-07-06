package ru.evgenykuzakov.pizza_shift_2025.navigation

import ru.evgenykuzakov.resource.R as Res

sealed class NavigationItem(
    val screen: Screen,
    val titleResId: Int,
    val iconResId: Int
) {
    data object Pizza: NavigationItem(
        screen = Screen.PizzaScreen,
        titleResId = Res.string.pizza,
        iconResId = Res.drawable.ic_pizza

    )
    data object Order: NavigationItem(
        screen = Screen.OrdersScreen,
        titleResId = Res.string.orders,
        iconResId = Res.drawable.ic_order

    )
    data object Cart: NavigationItem(
        screen = Screen.CartScreen,
        titleResId = Res.string.cart,
        iconResId = Res.drawable.ic_cart

    )
    data object Profile: NavigationItem(
        screen = Screen.ProfileScreen,
        titleResId = Res.string.profile,
        iconResId = Res.drawable.ic_profile

    )
}