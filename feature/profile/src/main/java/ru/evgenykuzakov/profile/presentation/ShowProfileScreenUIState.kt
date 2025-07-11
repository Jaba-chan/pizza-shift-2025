package ru.evgenykuzakov.profile.presentation

import ru.evgenykuzakov.user.User

sealed interface ShowProfileScreenUIState {

    data class Content(val user: User, ) : ShowProfileScreenUIState

    data object Loading : ShowProfileScreenUIState

    data class Error(val message: String) : ShowProfileScreenUIState
}