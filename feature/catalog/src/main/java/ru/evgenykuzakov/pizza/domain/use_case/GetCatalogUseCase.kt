package ru.evgenykuzakov.pizza.domain.use_case

import ru.evgenykuzakov.pizza.domain.model.Catalog
import ru.evgenykuzakov.pizza.domain.repository.PizzaRepository
import javax.inject.Inject

class GetCatalogUseCase @Inject constructor(
    private val repository: PizzaRepository
) : suspend () -> List<Catalog> by repository::getCatalog