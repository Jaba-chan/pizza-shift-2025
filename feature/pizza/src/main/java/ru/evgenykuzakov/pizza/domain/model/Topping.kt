package ru.evgenykuzakov.pizza.domain.model

import ru.evgenykuzakov.pizza.domain.model.type.IngredientType

data class Topping(
    val img: String,
    val price: Int,
    val type: IngredientType
)