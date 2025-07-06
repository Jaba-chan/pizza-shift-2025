package ru.evgenykuzakov.pizza.data.mapper

import ru.evgenykuzakov.models.pizza.type.IngredientType
import ru.evgenykuzakov.pizza.data.model.ToppingDto

fun ToppingDto.toDomain() = ru.evgenykuzakov.models.pizza.Topping(
    img = img,
    price = price,
    type = IngredientType.fromString(type)
)