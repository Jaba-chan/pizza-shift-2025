package ru.evgenykuzakov.pizza.data.model


import kotlinx.serialization.Serializable

@Serializable
data class CatalogDto(
    val allergens: List<String>,
    val calories: Int,
    val carbohydrates: String,
    val description: String,
    val doughs: List<DoughDto>,
    val id: String,
    val img: String,
    val ingredients: List<IngredientDto>,
    val isGlutenFree: Boolean,
    val isHit: Boolean,
    val isNew: Boolean,
    val isVegetarian: Boolean,
    val name: String,
    val protein: String,
    val sizes: List<SizeDto>,
    val sodium: String,
    val toppings: List<ToppingDto>,
    val totalFat: String
)