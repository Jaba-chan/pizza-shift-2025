package ru.evgenykuzakov.cart.domain.model

import ru.evgenykuzakov.cart.data.database.model.DoughEntity
import ru.evgenykuzakov.cart.data.database.model.IngredientEntity
import ru.evgenykuzakov.cart.data.database.model.SizeEntity
import ru.evgenykuzakov.model.pizza.Pizza

data class CartItem(
    val pizza: Pizza,
    val count: Int
)