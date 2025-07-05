package ru.evgenykuzakov.auth.data.model


import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val city: String?,
    val email: String?,
    val firstname: String?,
    val lastname: String?,
    val middlename: String?,
    val phone: String
)