package ru.evgenykuzakov.payment.data.mapper

import ru.evgenykuzakov.cart.domain.model.CartItem
import ru.evgenykuzakov.pizza.PizzaShort

fun CartItem.toShort() = PizzaShort(
    pizzaId = pizza.pizzaId,
    size = pizza.size,
    dough = pizza.dough,
    toppings = pizza.toppings
)