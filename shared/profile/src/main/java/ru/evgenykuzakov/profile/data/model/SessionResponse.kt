package ru.evgenykuzakov.profile.data.model


import kotlinx.serialization.Serializable

@Serializable
data class SessionResponse(
    val reason: String?,
    val success: Boolean,
    val user: UserDto
)