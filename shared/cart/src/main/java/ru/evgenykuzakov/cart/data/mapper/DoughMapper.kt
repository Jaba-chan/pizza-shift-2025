package ru.evgenykuzakov.cart.data.mapper

import ru.evgenykuzakov.cart.data.database.model.DoughEntity
import ru.evgenykuzakov.model.pizza.Dough
import ru.evgenykuzakov.model.pizza.type.DoughType

fun DoughEntity.toDomain() = Dough(
    price = price,
    type = DoughType.fromString(type)
)

fun Dough.toEntity() = DoughEntity(
    price = price,
    type = type.name
)