package ru.evgenykuzakov.cart.data.database.model

import kotlinx.serialization.Serializable

@Serializable
data class SizeEntity(
    val price: Int,
    val type: String
)
