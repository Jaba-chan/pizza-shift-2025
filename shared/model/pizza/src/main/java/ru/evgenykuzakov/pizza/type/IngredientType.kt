package ru.evgenykuzakov.pizza.type

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
                "PINEAPPLE" -> Pineapple
                "MOZZARELLA" -> Mozzarella
                "PEPERONI" -> Peperoni
                "GREEN_PEPPER" -> GreenPepper
                "MUSHROOMS" -> Mushrooms
                "BASIL" -> Basil
                "CHEDDAR" -> Cheddar
                "PARMESAN" -> Parmesan
                "FETA" -> Feta
                "HAM" -> Ham
                "PICKLE" -> Pickle
                "TOMATO" -> Tomato
                "BACON" -> Bacon
                "ONION" -> Onion
                "CHILE" -> Chile
                "SHRIMPS" -> Shrimps
                "CHICKEN_FILLET" -> ChickenFillet
                "MEATBALLS" -> Meatballs
                else -> throw IllegalArgumentException("Unknown ingredient type: $value")
            }
    }
}

