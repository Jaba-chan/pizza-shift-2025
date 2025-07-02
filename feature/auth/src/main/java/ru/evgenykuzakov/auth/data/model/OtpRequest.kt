package ru.evgenykuzakov.auth.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OtpRequest(
    @SerialName("phone")
    val phone: String
)