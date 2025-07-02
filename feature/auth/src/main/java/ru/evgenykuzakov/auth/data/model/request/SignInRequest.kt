package ru.evgenykuzakov.auth.data.model.request


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SignInRequest(
    @SerialName("code")
    val code: Int,
    @SerialName("phone")
    val phone: String
)