package ru.evgenykuzakov.auth.presentation

sealed class AuthActions {
    data object NavigateToCatalogScreen : AuthActions()
}