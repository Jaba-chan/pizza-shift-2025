package ru.evgenykuzakov.pizza.data.mapper

import ru.evgenykuzakov.models.pizza.type.SizeType
import ru.evgenykuzakov.pizza.data.model.SizeDto

fun SizeDto.toDomain() = ru.evgenykuzakov.models.pizza.Size(
    price = price,
    type = SizeType.fromString(type)
)