package ru.evgenykuzakov.pizza.domain.repository

import ru.evgenykuzakov.pizza.domain.model.Catalog
import ru.evgenykuzakov.pizza.domain.model.PizzaDetailInfo

interface PizzaRepository {

    suspend fun getCatalog(): List<Catalog>

    suspend fun getPizzaById(id: String): PizzaDetailInfo

}