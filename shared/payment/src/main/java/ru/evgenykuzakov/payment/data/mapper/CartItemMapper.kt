package ru.evgenykuzakov.payment.data.mapper

import ru.evgenykuzakov.cart.domain.model.CartItem
import ru.evgenykuzakov.pizza.PizzaShort

fun CartItem.toShort() = PizzaShort(
    name = pizza.name,
    pizzaId = pizza.pizzaId,
    size = pizza.size.type,
    dough = pizza.dough.type,
    toppings = pizza.toppings.map { it.type }
)