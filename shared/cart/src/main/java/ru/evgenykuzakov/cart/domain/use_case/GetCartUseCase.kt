package ru.evgenykuzakov.cart.domain.use_case

import kotlinx.coroutines.flow.Flow
import ru.evgenykuzakov.cart.domain.model.CartItem
import ru.evgenykuzakov.cart.domain.repository.CartRepository
import javax.inject.Inject

class GetCartUseCase @Inject constructor(
    private val repository: CartRepository
) : () -> Flow<List<CartItem>> by repository::getCart