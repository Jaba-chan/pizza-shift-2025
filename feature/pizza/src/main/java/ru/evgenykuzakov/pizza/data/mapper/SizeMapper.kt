package ru.evgenykuzakov.pizza.data.mapper

import ru.evgenykuzakov.pizza.data.model.SizeDto
import ru.evgenykuzakov.pizza.domain.model.Size
import ru.evgenykuzakov.pizza.domain.model.type.SizeType

fun SizeDto.toDomain() = Size(
    price = price,
    type = SizeType.fromString(type)
)