package ru.evgenykuzakov.pizza

import ru.evgenykuzakov.pizza.type.DoughType

data class Dough(
    val price: Int,
    val type: DoughType
)