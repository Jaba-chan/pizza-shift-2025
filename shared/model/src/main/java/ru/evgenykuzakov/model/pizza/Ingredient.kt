package ru.evgenykuzakov.model.pizza

import ru.evgenykuzakov.model.pizza.type.IngredientType

data class Ingredient(
    val img: String,
    val price: Int,
    val type: IngredientType
)