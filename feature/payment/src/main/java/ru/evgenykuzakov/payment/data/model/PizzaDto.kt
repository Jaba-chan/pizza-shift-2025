package ru.evgenykuzakov.payment.data.model

import kotlinx.serialization.Serializable


@Serializable
data class PizzaDto(
    val dough: String,
    val id: String,
    val size: String,
    val toppings: List<String>
)