package ru.evgenykuzakov.pizza.domain.model

import ru.evgenykuzakov.model.pizza.Dough
import ru.evgenykuzakov.model.pizza.Ingredient
import ru.evgenykuzakov.model.pizza.Size
import ru.evgenykuzakov.model.pizza.Topping
import ru.evgenykuzakov.pizza.data.model.DoughDto
import ru.evgenykuzakov.pizza.data.model.IngredientDto
import ru.evgenykuzakov.pizza.data.model.SizeDto
import ru.evgenykuzakov.pizza.data.model.ToppingDto

data class PizzaDetailInfo(
    val allergens: List<String>,
    val calories: Int,
    val carbohydrates: String,
    val description: String,
    val doughs: List<Dough>,
    val id: String,
    val img: String,
    val ingredients: List<Ingredient>,
    val isGlutenFree: Boolean,
    val isHit: Boolean,
    val isNew: Boolean,
    val isVegetarian: Boolean,
    val name: String,
    val protein: String,
    val sizes: List<Size>,
    val sodium: String,
    val toppings: List<Topping>,
    val totalFat: String
)