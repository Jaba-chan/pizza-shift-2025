package ru.evgenykuzakov.cart.data.mapper

import ru.evgenykuzakov.cart.data.database.model.ToppingEntity
import ru.evgenykuzakov.model.pizza.Topping
import ru.evgenykuzakov.model.pizza.type.IngredientType

fun ToppingEntity.toDomain() = Topping(
    img = img,
    price = price,
    type = IngredientType.fromString(type)
)

fun Topping.toEntity() = ToppingEntity(
    img = img,
    price = price,
    type = type.name
)