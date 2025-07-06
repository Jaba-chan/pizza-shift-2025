package ru.evgenykuzakov.pizza.data.mapper

import ru.evgenykuzakov.cart.domain.model.IngredientType
import ru.evgenykuzakov.pizza.data.model.ToppingDto

fun ToppingDto.toDomain() = ru.evgenykuzakov.cart.domain.model.Topping(
    img = img,
    price = price,
    type = ru.evgenykuzakov.cart.domain.model.IngredientType.fromString(type)
)