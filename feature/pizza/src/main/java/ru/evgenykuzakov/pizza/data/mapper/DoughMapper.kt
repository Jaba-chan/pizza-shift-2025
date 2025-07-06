package ru.evgenykuzakov.pizza.data.mapper

import ru.evgenykuzakov.cart.domain.model.DoughType
import ru.evgenykuzakov.pizza.data.model.DoughDto

fun DoughDto.toDomain() = ru.evgenykuzakov.cart.domain.model.Dough(
    price = price,
    type = ru.evgenykuzakov.cart.domain.model.DoughType.fromString(type)
)