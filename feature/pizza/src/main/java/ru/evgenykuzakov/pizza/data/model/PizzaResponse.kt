package ru.evgenykuzakov.pizza.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PizzaResponse(
    val catalog: List<Catalog>,
    val reason: String?,
    val success: Boolean
)