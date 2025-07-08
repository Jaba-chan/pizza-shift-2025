package ru.evgenykuzakov.cart.data.database.model

import androidx.room.Embedded

data class CartItemEntity(
    @Embedded val pizza: PizzaEntity,
    val count: Int
)