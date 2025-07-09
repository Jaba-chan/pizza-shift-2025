package ru.evgenykuzakov.pizza

data class PizzaShort(
    val pizzaId: String,
    val toppings: List<Ingredient>,
    val size: Size,
    val dough: Dough
)
