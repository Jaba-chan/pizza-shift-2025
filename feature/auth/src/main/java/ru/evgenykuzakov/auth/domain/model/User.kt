package ru.evgenykuzakov.auth.domain.model

data class User(
    val city: String,
    val email: String,
    val firstname: String,
    val lastname: String,
    val middlename: String,
    val phone: String
)