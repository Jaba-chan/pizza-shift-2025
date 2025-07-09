package ru.evgenykuzakov.pizza.data.mapper

import ru.evgenykuzakov.pizza.type.SizeType
import ru.evgenykuzakov.pizza.data.model.CatalogDto
import ru.evgenykuzakov.pizza.domain.model.Catalog
import ru.evgenykuzakov.pizza.domain.model.PizzaDetailInfo

fun CatalogDto.toDomain() = Catalog(
    id = id,
    description = description,
    img = img,
    name = name,
    priceFrom = sizes.map { it.toDomain() }.first { it.type == SizeType.Small }.price
)

fun CatalogDto.toPizzaDetailInfo() = PizzaDetailInfo(
    allergens = allergens,
    calories = calories,
    carbohydrates = carbohydrates,
    description = description,
    doughs = doughs.map { it.toDomain() },
    id = id,
    img = img,
    ingredients = ingredients.map { it.toDomain() },
    isGlutenFree = isGlutenFree,
    isHit = isHit,
    isNew = isNew,
    isVegetarian = isVegetarian,
    name = name,
    protein = protein,
    sizes = sizes.map { it.toDomain() },
    sodium = sodium,
    toppings = toppings.map { it.toDomain() },
    totalFat = totalFat,
)

fun PizzaDetailInfo.toCatalog() = Catalog(
    description = description,
    id = id,
    img = img,
    name = name,
    priceFrom = sizes.minOf { it.price }
)