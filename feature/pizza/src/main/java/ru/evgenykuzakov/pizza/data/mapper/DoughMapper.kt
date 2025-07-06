package ru.evgenykuzakov.pizza.data.mapper

import ru.evgenykuzakov.model.pizza.Dough
import ru.evgenykuzakov.model.pizza.type.DoughType
import ru.evgenykuzakov.pizza.data.model.DoughDto

fun DoughDto.toDomain() = Dough(
    price = price,
    type = DoughType.fromString(type)
)