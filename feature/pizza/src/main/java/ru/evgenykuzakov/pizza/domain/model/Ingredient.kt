package ru.evgenykuzakov.pizza.domain.model

import ru.evgenykuzakov.pizza.domain.model.type.IngredientType

data class Ingredient(
    val img: String,
    val price: Int,
    val type: IngredientType
)