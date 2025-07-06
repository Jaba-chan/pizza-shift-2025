package ru.evgenykuzakov.pizza.domain.repository

import ru.evgenykuzakov.pizza.domain.model.Catalog

interface PizzaRepository {

    suspend fun getCatalog(): List<Catalog>

}