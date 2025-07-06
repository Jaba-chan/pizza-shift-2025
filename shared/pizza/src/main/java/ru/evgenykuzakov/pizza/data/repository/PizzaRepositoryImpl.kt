package ru.evgenykuzakov.pizza.data.repository

import ru.evgenykuzakov.pizza.data.mapper.toCatalog
import ru.evgenykuzakov.pizza.data.mapper.toDomain
import ru.evgenykuzakov.pizza.data.mapper.toPizzaDetailInfo
import ru.evgenykuzakov.pizza.data.network.PizzaRetrofitApi
import ru.evgenykuzakov.pizza.domain.model.Catalog
import ru.evgenykuzakov.pizza.domain.model.PizzaDetailInfo
import ru.evgenykuzakov.pizza.domain.repository.PizzaRepository
import javax.inject.Inject

class PizzaRepositoryImpl @Inject constructor(
    private val api: PizzaRetrofitApi
) : PizzaRepository {

    private var cachedCatalog = emptyList<PizzaDetailInfo>()

    override suspend fun getCatalog(): List<Catalog> {
        if (cachedCatalog.isEmpty()) {
            cachedCatalog = api.getCatalog().catalog.map { it.toPizzaDetailInfo() }
        }
        return cachedCatalog.map { it.toCatalog() }
    }

    override suspend fun getPizzaById(id: String): PizzaDetailInfo {
        if (cachedCatalog.isEmpty()) {
            cachedCatalog = api.getCatalog().catalog.map { it.toPizzaDetailInfo() }
        }
        return cachedCatalog.first{ it.id == id }
    }


}