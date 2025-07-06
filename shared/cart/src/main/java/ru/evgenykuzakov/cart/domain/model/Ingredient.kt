package ru.evgenykuzakov.cart.domain.model

import ru.evgenykuzakov.cart.domain.model.type.IngredientType

data class Ingredient(
    val img: String,
    val price: Int,
    val type: IngredientType
)