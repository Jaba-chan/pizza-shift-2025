package ru.evgenykuzakov.pizza.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Dough(
    val price: Int,
    val type: String
)