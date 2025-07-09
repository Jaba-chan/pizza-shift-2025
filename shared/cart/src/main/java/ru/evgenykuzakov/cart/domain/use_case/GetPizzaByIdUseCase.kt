package ru.evgenykuzakov.cart.domain.use_case

import ru.evgenykuzakov.cart.domain.repository.CartRepository
import ru.evgenykuzakov.model.pizza.Pizza
import javax.inject.Inject

class GetPizzaByIdUseCase @Inject constructor(
    private val repository: CartRepository
) : suspend (Long) -> Pizza? by repository::getPizzaById