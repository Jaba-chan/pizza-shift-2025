package ru.evgenykuzakov.cart.presentation

import ru.evgenykuzakov.cart.domain.model.CartItem

sealed interface CartScreenUIState {

    data class Content(val cart: List<CartItem>) : CartScreenUIState

    data object Loading : CartScreenUIState

    data class Error(val message: String) :
        CartScreenUIState
}

