package ru.evgenykuzakov.pizza.data.mapper

import ru.evgenykuzakov.model.pizza.Ingredient
import ru.evgenykuzakov.model.pizza.type.IngredientType
import ru.evgenykuzakov.pizza.data.model.IngredientDto

fun IngredientDto.toDomain() = Ingredient(
    img = img,
    price = price,
    type = IngredientType.fromString(type)
)