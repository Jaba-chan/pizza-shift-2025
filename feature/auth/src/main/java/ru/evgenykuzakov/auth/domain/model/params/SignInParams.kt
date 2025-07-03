package ru.evgenykuzakov.auth.domain.model.params

data class SignInParams(
    val code: Int,
    val phone: String
)