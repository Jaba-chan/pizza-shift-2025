package ru.evgenykuzakov.pizza.data.mapper

import ru.evgenykuzakov.models.pizza.type.IngredientType
import ru.evgenykuzakov.pizza.data.model.IngredientDto

fun IngredientDto.toDomain() = ru.evgenykuzakov.models.pizza.Ingredient(
    img = img,
    price = price,
    type = IngredientType.fromString(type)
)