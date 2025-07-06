package ru.evgenykuzakov.pizza.domain.model

data class Catalog(
    val id: String,
    val name: String,
    val description: String,
    val priceFrom: Int,
    val img: String
)