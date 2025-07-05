package ru.evgenykuzakov.pizza.domain.model.type

sealed class IngredientType(val name: String) {
    data object Pineapple : IngredientType("PINEAPPLE")
    data object Mozzarella : IngredientType("MOZZARELLA")
    data object Peperoni : IngredientType("PEPERONI")
    data object GreenPepper : IngredientType("GREEN_PEPPER")
    data object Mushrooms : IngredientType("MUSHROOMS")
    data object Basil : IngredientType("BASIL")
    data object Cheddar : IngredientType("CHEDDAR")
    data object Parmesan : IngredientType("PARMESAN")
    data object Feta : IngredientType("FETA")
    data object Ham : IngredientType("HAM")
    data object Pickle : IngredientType("PICKLE")
    data object Tomato : IngredientType("TOMATO")
    data object Bacon : IngredientType("BACON")
    data object Onion : IngredientType("ONION")
    data object Chile : IngredientType("CHILE")
    data object Shrimps : IngredientType("SHRIMPS")
    data object ChickenFillet : IngredientType("CHICKEN_FILLET")
    data object Meatballs : IngredientType("MEATBALLS")

    companion object {
        fun fromString(value: String): IngredientType =
            when (value.uppercase()) {
                "PINEAPPLE" -> IngredientType.Pineapple
                "MOZZARELLA" -> IngredientType.Mozzarella
                "PEPERONI" -> IngredientType.Peperoni
                "GREEN_PEPPER" -> IngredientType.GreenPepper
                "MUSHROOMS" -> IngredientType.Mushrooms
                "BASIL" -> IngredientType.Basil
                "CHEDDAR" -> IngredientType.Cheddar
                "PARMESAN" -> IngredientType.Parmesan
                "FETA" -> IngredientType.Feta
                "HAM" -> IngredientType.Ham
                "PICKLE" -> IngredientType.Pickle
                "TOMATO" -> IngredientType.Tomato
                "BACON" -> IngredientType.Bacon
                "ONION" -> IngredientType.Onion
                "CHILE" -> IngredientType.Chile
                "SHRIMPS" -> IngredientType.Shrimps
                "CHICKEN_FILLET" -> IngredientType.ChickenFillet
                "MEATBALLS" -> IngredientType.Meatballs
                else -> throw IllegalArgumentException("Unknown ingredient type: $value")
            }
    }
}

