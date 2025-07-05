package ru.evgenykuzakov.pizza.data.mapper

import ru.evgenykuzakov.pizza.data.model.ToppingDto
import ru.evgenykuzakov.pizza.domain.model.Topping
import ru.evgenykuzakov.pizza.domain.model.type.IngredientType

fun ToppingDto.toDomain() = Topping(
    img = img,
    price = price,
    type = IngredientType.fromString(type)
)