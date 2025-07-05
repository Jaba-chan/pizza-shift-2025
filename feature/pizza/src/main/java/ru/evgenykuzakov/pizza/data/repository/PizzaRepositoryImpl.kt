package ru.evgenykuzakov.pizza.data.repository

import ru.evgenykuzakov.pizza.data.mapper.toDomain
import ru.evgenykuzakov.pizza.data.network.PizzaRetrofitApi
import ru.evgenykuzakov.pizza.domain.model.Catalog
import ru.evgenykuzakov.pizza.domain.repository.PizzaRepository
import javax.inject.Inject

class PizzaRepositoryImpl @Inject constructor(
    private val api: PizzaRetrofitApi
) : PizzaRepository {

    private var cachedCatalog = emptyList<Catalog>()

    override suspend fun getCatalog(): List<Catalog> =
        cachedCatalog.ifEmpty {
            cachedCatalog = api.getCatalog().catalog.map { it.toDomain() }
            cachedCatalog
        }
}