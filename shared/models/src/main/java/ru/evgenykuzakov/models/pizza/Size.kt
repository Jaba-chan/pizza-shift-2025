package ru.evgenykuzakov.models.pizza

import ru.evgenykuzakov.models.pizza.type.SizeType

data class Size(
    val price: Int,
    val type: SizeType
)
