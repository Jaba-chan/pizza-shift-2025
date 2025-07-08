package ru.evgenykuzakov.cart.domain.repository

import ru.evgenykuzakov.model.pizza.Pizza

interface CartRepository {

    suspend fun getCart(): List<Pizza>

    suspend fun addToCard(pizza: Pizza)

}