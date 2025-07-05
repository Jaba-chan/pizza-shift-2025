package ru.evgenykuzakov.pizza.domain.model

import ru.evgenykuzakov.pizza.domain.model.type.DoughType

data class Dough(
    val price: Int,
    val type: DoughType
)