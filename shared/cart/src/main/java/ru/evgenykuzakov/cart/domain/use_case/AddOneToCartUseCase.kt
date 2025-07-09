package ru.evgenykuzakov.cart.domain.use_case

import ru.evgenykuzakov.cart.domain.repository.CartRepository
import ru.evgenykuzakov.pizza.Pizza
import javax.inject.Inject

class AddOneToCartUseCase @Inject constructor(
    private val repository: CartRepository
){
    suspend operator fun invoke(pizza: Pizza) = repository.addToCart(pizza.copy(id = 0))
}