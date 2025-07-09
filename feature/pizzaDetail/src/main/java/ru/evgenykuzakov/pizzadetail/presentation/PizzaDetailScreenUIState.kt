package ru.evgenykuzakov.pizzadetail.presentation

import ru.evgenykuzakov.pizza.Pizza
import ru.evgenykuzakov.pizza.domain.model.PizzaDetailInfo

sealed interface PizzaDetailScreenUIState {

    data class Content(
        val pizza: PizzaDetailInfo,
        val userChoice: Pizza
    ) : PizzaDetailScreenUIState

    data object Loading : PizzaDetailScreenUIState

    data class Error(val message: String) :
        PizzaDetailScreenUIState
}

