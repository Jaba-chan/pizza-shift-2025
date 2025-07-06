package ru.evgenykuzakov.pizza.data.mapper

import ru.evgenykuzakov.models.pizza.type.DoughType
import ru.evgenykuzakov.pizza.data.model.DoughDto

fun DoughDto.toDomain() = ru.evgenykuzakov.models.pizza.Dough(
    price = price,
    type = DoughType.fromString(type)
)