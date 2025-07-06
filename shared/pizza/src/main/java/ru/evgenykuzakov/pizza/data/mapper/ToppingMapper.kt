package ru.evgenykuzakov.pizza.data.mapper

import ru.evgenykuzakov.model.pizza.Topping
import ru.evgenykuzakov.model.pizza.type.IngredientType
import ru.evgenykuzakov.pizza.data.model.ToppingDto

fun ToppingDto.toDomain() = Topping(
    img = img,
    price = price,
    type = IngredientType.fromString(type)
)