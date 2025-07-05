package ru.evgenykuzakov.pizza.domain.model

import ru.evgenykuzakov.pizza.domain.model.type.SizeType

data class Size(
    val price: Int,
    val type: SizeType
)
