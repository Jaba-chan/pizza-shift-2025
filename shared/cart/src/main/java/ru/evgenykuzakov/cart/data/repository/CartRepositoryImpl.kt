package ru.evgenykuzakov.cart.data.repository

import ru.evgenykuzakov.cart.data.database.dao.CartDao
import ru.evgenykuzakov.cart.data.mapper.toDomain
import ru.evgenykuzakov.cart.data.mapper.toEntity
import ru.evgenykuzakov.cart.domain.model.CartItem
import ru.evgenykuzakov.cart.domain.repository.CartRepository
import ru.evgenykuzakov.model.pizza.Pizza
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor(
    private val dao: CartDao
) : CartRepository {

    override suspend fun getCart(): List<CartItem> = dao.getCart().map { it.toDomain() }

    override suspend fun addToCard(pizza: Pizza) = dao.addToCart(pizza.toEntity())
}