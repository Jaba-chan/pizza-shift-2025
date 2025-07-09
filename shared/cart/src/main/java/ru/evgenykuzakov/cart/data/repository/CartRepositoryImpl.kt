package ru.evgenykuzakov.cart.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
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

    override fun getCart(): Flow<List<CartItem>> = dao.getCartAsFlow().map { list -> list.map { it.toDomain() }}

    override suspend fun addToCart(pizza: Pizza) = dao.addToCart(pizza.toEntity())

    override suspend fun deleteFromCart(pizza: Pizza) =
        dao.deleteFromCart(
            pizzaId = pizza.id,
            size = pizza.size.toEntity(),
            dough = pizza.dough.toEntity(),
            toppings = pizza.toppings.map { it.toEntity() }
        )

    override fun getCartSize(): Flow<Int> = dao.getCartSizeAsFlow()
}