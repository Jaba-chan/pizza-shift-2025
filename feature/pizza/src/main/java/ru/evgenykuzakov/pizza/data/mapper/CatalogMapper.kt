package ru.evgenykuzakov.pizza.data.mapper

import ru.evgenykuzakov.pizza.data.model.CatalogDto
import ru.evgenykuzakov.pizza.domain.model.Catalog
import ru.evgenykuzakov.pizza.domain.model.type.SizeType

fun CatalogDto.toDomain() = Catalog(
    id = id,
    description = description,
    img = img,
    name = name,
    priceFrom = sizes.map { it.toDomain() }.first{ it.type == SizeType.Small }.price
)
