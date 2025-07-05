package ru.evgenykuzakov.auth.data.model.request


import kotlinx.serialization.Serializable

@Serializable
data class OtpRequest(
    val phone: String
)