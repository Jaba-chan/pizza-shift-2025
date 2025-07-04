package ru.evgenykuzakov.auth.presentation

data class AuthScreenUIState(
    val phone: String = "",
    val phoneStatus: SentState = SentState.Idle,
    val codeState: CodeState? = null
)

data class CodeState(
    val code: String = "",
    val codeStatus: SentState
)

sealed interface SentState {

    object Idle: SentState

    object Loading : SentState

    data class Error(val message: String) :
        SentState
}

