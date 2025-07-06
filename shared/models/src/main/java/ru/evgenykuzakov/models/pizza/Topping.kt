package ru.evgenykuzakov.models.pizza

import ru.evgenykuzakov.models.pizza.type.IngredientType

data class Topping(
    val img: String,
    val price: Int,
    val type: IngredientType
)