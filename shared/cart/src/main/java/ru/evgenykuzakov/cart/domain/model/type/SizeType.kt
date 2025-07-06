package ru.evgenykuzakov.cart.domain.model.type

sealed class SizeType(val name: String) {
    data object Small : SizeType("SMALL")
    data object Medium : SizeType("MEDIUM")
    data object Large : SizeType("LARGE")

    companion object {
        fun fromString(value: String): SizeType =
            when (value.uppercase()) {
                "SMALL" -> Small
                "MEDIUM" -> Medium
                "LARGE" -> Large
                else -> throw IllegalArgumentException("Unknown size type: $value")
            }
    }
}
