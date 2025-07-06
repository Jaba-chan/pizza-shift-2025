package ru.evgenykuzakov.cart.data.mapper

import ru.evgenykuzakov.cart.data.database.model.ToppingEntity
import ru.evgenykuzakov.cart.domain.model.type.IngredientType

fun ToppingEntity.toDomain() = ru.evgenykuzakov.cart.domain.model.Topping(
    img = img,
    price = price,
    type = IngredientType.fromString(type)
)