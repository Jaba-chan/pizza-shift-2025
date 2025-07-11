package ru.evgenykuzakov.cart.domain.use_case

import ru.evgenykuzakov.cart.domain.repository.CartRepository
import javax.inject.Inject

class ClearCartUseCase @Inject constructor(
    private val repository: CartRepository
) : suspend () -> Unit by repository::clearCart