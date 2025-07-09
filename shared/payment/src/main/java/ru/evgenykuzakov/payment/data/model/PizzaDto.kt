package ru.evgenykuzakov.payment.data.model


import kotlinx.serialization.Serializable
import ru.evgenykuzakov.pizza.data.model.DoughDto
import ru.evgenykuzakov.pizza.data.model.IngredientDto
import ru.evgenykuzakov.pizza.data.model.SizeDto

@Serializable
data class PizzaDto(
    val dough: DoughDto,
    val id: String,
    val size: SizeDto,
    val toppings: List<IngredientDto>
)