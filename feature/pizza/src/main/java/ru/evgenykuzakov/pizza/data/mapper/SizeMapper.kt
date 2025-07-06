package ru.evgenykuzakov.pizza.data.mapper

import ru.evgenykuzakov.cart.domain.model.SizeType
import ru.evgenykuzakov.pizza.data.model.SizeDto

fun SizeDto.toDomain() = ru.evgenykuzakov.cart.domain.model.Size(
    price = price,
    type = ru.evgenykuzakov.cart.domain.model.SizeType.fromString(type)
)