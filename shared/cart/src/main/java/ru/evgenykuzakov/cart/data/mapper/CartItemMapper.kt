package ru.evgenykuzakov.cart.data.mapper

import ru.evgenykuzakov.cart.data.database.model.CartItemEntity
import ru.evgenykuzakov.cart.domain.model.CartItem

fun CartItemEntity.toDomain() = CartItem(
    pizza = pizza.toDomain(),
    count = count
)