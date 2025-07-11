package ru.evgenykuzakov.pizza.domain.model

import ru.evgenykuzakov.pizza.Dough
import ru.evgenykuzakov.pizza.Ingredient
import ru.evgenykuzakov.pizza.Size

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
    val toppings: List<Ingredient>,
    val totalFat: String
)