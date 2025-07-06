package ru.evgenykuzakov.model.pizza

import ru.evgenykuzakov.model.pizza.type.DoughType

data class Dough(
    val price: Int,
    val type: DoughType
)