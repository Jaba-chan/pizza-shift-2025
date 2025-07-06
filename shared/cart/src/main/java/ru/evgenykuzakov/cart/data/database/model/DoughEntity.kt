package ru.evgenykuzakov.cart.data.database.model

import kotlinx.serialization.Serializable

@Serializable
data class DoughEntity(
    val price: Int,
    val type: String
)