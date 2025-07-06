package ru.evgenykuzakov.model.pizza

import ru.evgenykuzakov.model.pizza.type.SizeType

data class Size(
    val price: Int,
    val type: SizeType
)
