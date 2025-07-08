package ru.evgenykuzakov.model.pizza

data class Pizza(
    val id: String,
    val name: String,
    val img: String,
    val toppings: List<Ingredient>,
    val size: Size,
    val dough: Dough
)