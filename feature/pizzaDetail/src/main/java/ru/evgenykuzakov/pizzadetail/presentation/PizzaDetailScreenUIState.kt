package ru.evgenykuzakov.pizzadetail.presentation

import ru.evgenykuzakov.pizza.domain.model.PizzaDetailInfo

sealed interface PizzaDetailScreenUIState {

    data class Content(val pizza: PizzaDetailInfo) : PizzaDetailScreenUIState

    data object Loading : PizzaDetailScreenUIState

    data class Error(val message: String) :
        PizzaDetailScreenUIState
}

