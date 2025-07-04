package ru.evgenykuzakov.auth.presentation

data class AuthScreenUIState(
    val phone: String = "",
    val phoneStatus: PhoneStatus = PhoneStatus.Idle,
    val codeState: CodeState? = null
)

sealed interface PhoneStatus {

    object Idle: PhoneStatus

    object Loading : PhoneStatus

    data class Error(val message: String) : PhoneStatus
}

data class CodeState(
    val code: String = "",
    val codeStatus: CodeStatus
)
sealed interface CodeStatus {

    object Idle: CodeStatus

    object Loading : CodeStatus

    data class Error(val message: String) : CodeStatus

}