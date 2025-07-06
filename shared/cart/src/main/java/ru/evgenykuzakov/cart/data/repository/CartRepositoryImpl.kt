package ru.evgenykuzakov.cart.data.repository

import ru.evgenykuzakov.cart.data.database.CartDatabase
import ru.evgenykuzakov.cart.data.mapper.toDomain
import ru.evgenykuzakov.cart.domain.model.Pizza
import ru.evgenykuzakov.cart.domain.repository.CartRepository
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor(
    private val database: CartDatabase
) : CartRepository {
    override suspend fun getCart(): List<Pizza> = database.cartDao().getCart().map { it.toDomain() }
}