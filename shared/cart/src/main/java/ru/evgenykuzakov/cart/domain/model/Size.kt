package ru.evgenykuzakov.cart.domain.model

import ru.evgenykuzakov.cart.domain.model.type.SizeType

data class Size(
    val price: Int,
    val type: SizeType
)
