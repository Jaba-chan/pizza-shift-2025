package ru.evgenykuzakov.pizza.domain.model.type

sealed class DoughType(val name: String) {
    data object Thin : DoughType("THIN")
    data object Thick : DoughType("THICK")

    companion object {
        fun fromString(value: String): DoughType =
            when (value.uppercase()) {
                "THIN" -> Thin
                "THICK" -> Thick
                else -> throw IllegalArgumentException("Unknown dough type: $value")
            }
    }
}
