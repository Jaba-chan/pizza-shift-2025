package ru.evgenykuzakov.auth.data.model.request


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OtpRequest(
    @SerialName("phone")
    val phone: String
)