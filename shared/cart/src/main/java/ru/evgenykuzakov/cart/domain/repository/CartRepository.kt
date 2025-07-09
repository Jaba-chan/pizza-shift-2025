package ru.evgenykuzakov.cart.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.evgenykuzakov.cart.domain.model.CartItem
import ru.evgenykuzakov.model.pizza.Pizza

interface CartRepository {

    fun getCart(): Flow<List<CartItem>>

    suspend fun addToCart(pizza: Pizza)

    suspend fun getPizzaById(id: Long): Pizza?

    suspend fun deleteFromCart(pizza: Pizza)

    fun getCartSize(): Flow<Int>

}