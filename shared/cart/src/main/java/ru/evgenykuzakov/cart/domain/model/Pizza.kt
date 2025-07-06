package ru.evgenykuzakov.cart.domain.model

data class Pizza(
    val id: String,
    val name: String,
    val img: String,
    val toppings: List<Topping> = emptyList(),
    val size: Size,
    val dough: Dough
)