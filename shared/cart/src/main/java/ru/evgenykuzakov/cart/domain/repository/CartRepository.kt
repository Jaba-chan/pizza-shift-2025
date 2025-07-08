package ru.evgenykuzakov.cart.domain.repository

import ru.evgenykuzakov.cart.domain.model.CartItem
import ru.evgenykuzakov.model.pizza.Pizza

interface CartRepository {

    suspend fun getCart(): List<CartItem>

    suspend fun addToCard(pizza: Pizza)

}