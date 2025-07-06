package ru.evgenykuzakov.models.pizza

import ru.evgenykuzakov.models.pizza.type.DoughType

data class Dough(
    val price: Int,
    val type: DoughType
)