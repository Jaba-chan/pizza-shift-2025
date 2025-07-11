package ru.evgenykuzakov.payment.data.model


import kotlinx.serialization.Serializable
import ru.evgenykuzakov.pizza.data.model.DoughDto
import ru.evgenykuzakov.pizza.data.model.IngredientDto
import ru.evgenykuzakov.pizza.data.model.SizeDto

@Serializable
data class PizzaDto(
    val dough: String,
    val id: String,
    val size: String,
    val toppings: List<String>
)