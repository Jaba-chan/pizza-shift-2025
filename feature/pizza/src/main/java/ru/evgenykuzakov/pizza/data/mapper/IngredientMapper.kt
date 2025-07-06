package ru.evgenykuzakov.pizza.data.mapper

import ru.evgenykuzakov.cart.domain.model.IngredientType
import ru.evgenykuzakov.pizza.data.model.IngredientDto

fun IngredientDto.toDomain() = ru.evgenykuzakov.cart.domain.model.Ingredient(
    img = img,
    price = price,
    type = ru.evgenykuzakov.cart.domain.model.IngredientType.fromString(type)
)