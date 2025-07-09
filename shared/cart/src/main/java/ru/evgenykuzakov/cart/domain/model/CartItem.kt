package ru.evgenykuzakov.cart.domain.model

import ru.evgenykuzakov.pizza.Pizza

data class CartItem(
    val pizza: Pizza,
    val count: Int
)