package ru.evgenykuzakov.cart.data.mapper

import ru.evgenykuzakov.cart.data.database.model.PizzaEntity
import ru.evgenykuzakov.cart.domain.model.Pizza

fun PizzaEntity.toDomain() = Pizza(
    id = id,
    img = img,
    name = name,
    toppings = toppings.map { it.toDomain() },
    dough = dough.toDomain(),
    size = size.toDomain()
)
