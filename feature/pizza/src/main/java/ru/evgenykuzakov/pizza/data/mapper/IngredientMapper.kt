package ru.evgenykuzakov.pizza.data.mapper

import ru.evgenykuzakov.pizza.data.model.IngredientDto
import ru.evgenykuzakov.pizza.domain.model.Ingredient
import ru.evgenykuzakov.pizza.domain.model.type.IngredientType

fun IngredientDto.toDomain() = Ingredient(
    img = img,
    price = price,
    type = IngredientType.fromString(type)
)