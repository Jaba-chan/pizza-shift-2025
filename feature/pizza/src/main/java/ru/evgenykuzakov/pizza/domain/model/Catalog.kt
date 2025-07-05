package ru.evgenykuzakov.pizza.domain.model

data class Catalog(
    val id: String,
    val name: String,
    val description: String,
    val priceFrom: Int,
    val img: String,
    val isGlutenFree: Boolean,
    val isHit: Boolean,
    val isNew: Boolean,
    val isVegetarian: Boolean
)