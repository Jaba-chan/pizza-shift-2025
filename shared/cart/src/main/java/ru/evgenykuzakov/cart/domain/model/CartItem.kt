package ru.evgenykuzakov.cart.domain.model

import ru.evgenykuzakov.model.pizza.Pizza

data class CartItem(
    val pizza: Pizza,
    val count: Int
)