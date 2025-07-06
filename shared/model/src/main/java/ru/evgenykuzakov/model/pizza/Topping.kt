package ru.evgenykuzakov.model.pizza

import ru.evgenykuzakov.model.pizza.type.IngredientType

data class Topping(
    val img: String,
    val price: Int,
    val type: IngredientType
)