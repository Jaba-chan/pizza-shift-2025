package ru.evgenykuzakov.cart.domain.model

import ru.evgenykuzakov.cart.domain.model.type.DoughType

data class Dough(
    val price: Int,
    val type: DoughType
)