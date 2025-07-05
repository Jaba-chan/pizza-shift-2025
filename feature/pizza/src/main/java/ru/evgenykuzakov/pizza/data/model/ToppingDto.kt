package ru.evgenykuzakov.pizza.data.model


import kotlinx.serialization.Serializable

@Serializable
data class ToppingDto(
    val img: String,
    val price: Int,
    val type: String
)