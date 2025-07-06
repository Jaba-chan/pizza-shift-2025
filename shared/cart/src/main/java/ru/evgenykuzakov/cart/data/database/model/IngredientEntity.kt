package ru.evgenykuzakov.cart.data.database.model

import kotlinx.serialization.Serializable

@Serializable
data class IngredientEntity(
    val img: String,
    val price: Int,
    val type: String
)