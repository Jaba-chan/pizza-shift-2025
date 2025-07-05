package ru.evgenykuzakov.pizza.data.mapper

import ru.evgenykuzakov.pizza.data.model.DoughDto
import ru.evgenykuzakov.pizza.domain.model.Dough
import ru.evgenykuzakov.pizza.domain.model.type.DoughType

fun DoughDto.toDomain() = Dough(
    price = price,
    type = DoughType.fromString(type)
)