package ru.evgenykuzakov.payment.data.mapper

import ru.evgenykuzakov.payment.data.model.PizzaDto
import ru.evgenykuzakov.pizza.Pizza
import ru.evgenykuzakov.pizza.PizzaShort
import ru.evgenykuzakov.pizza.data.mapper.toDomain
import ru.evgenykuzakov.pizza.data.mapper.toDto

fun PizzaShort.toDto() = PizzaDto(
    id = pizzaId,
    dough = dough.toDto(),
    size = size.toDto(),
    toppings = toppings.map { it.toDto() }
)

fun PizzaDto.toDomain() = PizzaShort(
    pizzaId = id,
    dough = dough.toDomain(),
    size = size.toDomain(),
    toppings = toppings.map { it.toDomain() }
)