package ru.evgenykuzakov.cart.data.mapper

import ru.evgenykuzakov.cart.data.database.model.SizeEntity
import ru.evgenykuzakov.cart.domain.model.Size
import ru.evgenykuzakov.cart.domain.model.type.SizeType

fun SizeEntity.toDomain() = Size(
    price = price,
    type = SizeType.fromString(type)
)

fun Size.toEntity() = SizeEntity(
    price = price,
    type = type.name
)