package ru.evgenykuzakov.cart.domain.use_case

import ru.evgenykuzakov.cart.domain.repository.CartRepository
import ru.evgenykuzakov.model.pizza.Pizza
import javax.inject.Inject

class DeleteFromCartUseCase @Inject constructor(
    private val repository: CartRepository
) : suspend (Pizza) -> Unit by repository::deleteFromCart