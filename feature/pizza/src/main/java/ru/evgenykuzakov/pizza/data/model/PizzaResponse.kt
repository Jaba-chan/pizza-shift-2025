package ru.evgenykuzakov.pizza.data.model


import kotlinx.serialization.Serializable

@Serializable
data class PizzaResponse(
    val catalog: List<CatalogDto>,
    val reason: String?,
    val success: Boolean
)