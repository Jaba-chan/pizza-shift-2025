package ru.evgenykuzakov.pizza.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Catalog(
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