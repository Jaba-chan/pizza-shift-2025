package ru.evgenykuzakov.pizza

import ru.evgenykuzakov.pizza.type.DoughType
import ru.evgenykuzakov.pizza.type.IngredientType
import ru.evgenykuzakov.pizza.type.SizeType

data class PizzaShort(
    val name: String,
    val pizzaId: String,
    val toppings: List<IngredientType>,
    val size: SizeType,
    val dough: DoughType
)