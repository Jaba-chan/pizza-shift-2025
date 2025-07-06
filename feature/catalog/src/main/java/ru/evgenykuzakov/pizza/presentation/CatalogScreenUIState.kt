package ru.evgenykuzakov.pizza.presentation

import ru.evgenykuzakov.pizza.domain.model.Catalog

sealed interface CatalogScreenUIState {

    data class Content(val catalog: List<Catalog>) : CatalogScreenUIState

    data object Loading : CatalogScreenUIState

    data class Error(val message: String) :
        CatalogScreenUIState
}

