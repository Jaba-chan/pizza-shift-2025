package ru.evgenykuzakov.cart.data.mapper

import ru.evgenykuzakov.cart.data.database.model.PizzaEntity
import ru.evgenykuzakov.model.pizza.Pizza

fun PizzaEntity.toDomain() = Pizza(
    id = id,
    pizzaId = pizzaId,
    img = img,
    name = name,
    toppings = toppings.map { it.toDomain() },
    dough = dough.toDomain(),
    size = size.toDomain()
)

fun Pizza.toEntity() = PizzaEntity(
    id = id,
    pizzaId = pizzaId,
    img = img,
    name = name,
    toppings = toppings.map { it.toEntity() },
    dough = dough.toEntity(),
    size = size.toEntity()
)
