package ru.evgenykuzakov.pizza.data.mapper

import ru.evgenykuzakov.pizza.Dough
import ru.evgenykuzakov.pizza.type.DoughType
import ru.evgenykuzakov.pizza.data.model.DoughDto

fun DoughDto.toDomain() = Dough(
    price = price,
    type = DoughType.fromString(type)
)

fun Dough.toDto() = DoughDto(
    price = price,
    type = type.name
)