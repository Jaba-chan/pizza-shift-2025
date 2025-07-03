package ru.evgenykuzakov.auth.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    @SerialName("city")
    val city: String?,
    @SerialName("email")
    val email: String?,
    @SerialName("firstname")
    val firstname: String?,
    @SerialName("lastname")
    val lastname: String?,
    @SerialName("middlename")
    val middlename: String?,
    @SerialName("phone")
    val phone: String?
)