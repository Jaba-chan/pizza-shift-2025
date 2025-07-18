package ru.evgenykuzakov.cart.data.mapper

import ru.evgenykuzakov.cart.data.database.model.IngredientEntity
import ru.evgenykuzakov.pizza.Ingredient
import ru.evgenykuzakov.pizza.type.IngredientType

fun IngredientEntity.toDomain() = Ingredient(
    img = img,
    price = price,
    type = IngredientType.fromString(type)
)

fun Ingredient.toEntity() = IngredientEntity(
    img = img,
    price = price,
    type = type.name
)