package ru.evgenykuzakov.auth.data.model


import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    val reason: String,
    val success: Boolean,
    val token: String,
    val user: UserDto
)