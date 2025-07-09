package ru.evgenykuzakov.cart.domain.use_case

import kotlinx.coroutines.flow.Flow
import ru.evgenykuzakov.cart.domain.repository.CartRepository
import javax.inject.Inject

class GetCartSizeUseCase @Inject constructor(
    private val repository: CartRepository
) : () -> Flow<Int> by repository::getCartSize