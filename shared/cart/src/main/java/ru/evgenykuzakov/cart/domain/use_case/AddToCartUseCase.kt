package ru.evgenykuzakov.cart.domain.use_case

import ru.evgenykuzakov.cart.domain.model.Pizza
import ru.evgenykuzakov.cart.domain.repository.CartRepository
import javax.inject.Inject

class AddToCartUseCase @Inject constructor(
    private val repository: CartRepository
) : suspend (Pizza) -> Unit by repository::addToCard