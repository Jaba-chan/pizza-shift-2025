package ru.evgenykuzakov.pizza.data.mapper

import ru.evgenykuzakov.pizza.Size
import ru.evgenykuzakov.pizza.type.SizeType
import ru.evgenykuzakov.pizza.data.model.SizeDto

fun SizeDto.toDomain() = Size(
    price = price,
    type = SizeType.fromString(type)
)