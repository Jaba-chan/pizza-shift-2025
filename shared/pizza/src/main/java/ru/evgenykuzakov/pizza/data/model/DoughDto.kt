package ru.evgenykuzakov.pizza.data.model


import kotlinx.serialization.Serializable

@Serializable
data class DoughDto(
    val price: Int,
    val type: String
)