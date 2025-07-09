package ru.evgenykuzakov.pizza

data class Pizza(
    val id: Long,
    val pizzaId: String,
    val name: String,
    val img: String,
    val toppings: List<Ingredient>,
    val size: Size,
    val dough: Dough
)

fun Pizza.totalCost() = this.size.price + this.dough.price + this.toppings.sumOf { it.price }