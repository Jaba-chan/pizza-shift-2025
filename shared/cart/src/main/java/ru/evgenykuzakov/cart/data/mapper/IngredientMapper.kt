package ru.evgenykuzakov.cart.data.mapper

import ru.evgenykuzakov.cart.data.database.model.IngredientEntity
import ru.evgenykuzakov.cart.domain.model.type.IngredientType

fun IngredientEntity.toDomain() = ru.evgenykuzakov.cart.domain.model.Ingredient(
    img = img,
    price = price,
    type = IngredientType.fromString(type)
)