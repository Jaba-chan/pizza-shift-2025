package ru.evgenykuzakov.cart.data.mapper

import ru.evgenykuzakov.cart.data.database.model.SizeEntity
import ru.evgenykuzakov.pizza.Size
import ru.evgenykuzakov.pizza.type.SizeType

fun SizeEntity.toDomain() = Size(
    price = price,
    type = SizeType.fromString(type)
)

fun Size.toEntity() = SizeEntity(
    price = price,
    type = type.name
)