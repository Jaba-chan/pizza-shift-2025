package ru.evgenykuzakov.auth.presentation

data class AuthScreenUIState(
    val phone: String = "",
    val isPhoneSent: Boolean = false,
    val code: String = "",
    val requestCodeTimer: Int? = null
)