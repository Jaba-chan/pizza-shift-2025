package ru.evgenykuzakov.pizza

import ru.evgenykuzakov.pizza.type.IngredientType

data class Topping(
    val img: String,
    val price: Int,
    val type: IngredientType
)