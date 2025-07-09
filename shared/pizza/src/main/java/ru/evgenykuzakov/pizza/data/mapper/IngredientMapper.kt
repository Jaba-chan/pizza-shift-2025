package ru.evgenykuzakov.pizza.data.mapper

import ru.evgenykuzakov.pizza.Ingredient
import ru.evgenykuzakov.pizza.type.IngredientType
import ru.evgenykuzakov.pizza.data.model.IngredientDto

fun IngredientDto.toDomain() = Ingredient(
    img = img,
    price = price,
    type = IngredientType.fromString(type)
)