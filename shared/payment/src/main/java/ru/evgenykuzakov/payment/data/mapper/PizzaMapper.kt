package ru.evgenykuzakov.payment.data.mapper

import ru.evgenykuzakov.payment.data.model.PizzaDto
import ru.evgenykuzakov.pizza.PizzaShort
import ru.evgenykuzakov.pizza.type.DoughType
import ru.evgenykuzakov.pizza.type.IngredientType
import ru.evgenykuzakov.pizza.type.SizeType

fun PizzaShort.toDto() = PizzaDto(
    id = pizzaId,
    dough = dough.name,
    size = size.name,
    toppings = toppings.map { it.name }
)

fun PizzaDto.toDomain(name: String) = PizzaShort(
    name = name,
    pizzaId = id,
    dough = DoughType.fromString(dough),
    size = SizeType.fromString(size),
    toppings = toppings.map { IngredientType.fromString(it) }
)