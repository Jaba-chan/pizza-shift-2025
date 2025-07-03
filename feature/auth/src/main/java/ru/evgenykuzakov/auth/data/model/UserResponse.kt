package ru.evgenykuzakov.auth.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    @SerialName("reason")
    val reason: String,
    @SerialName("success")
    val success: Boolean,
    @SerialName("token")
    val token: String,
    @SerialName("user")
    val user: UserDto
)