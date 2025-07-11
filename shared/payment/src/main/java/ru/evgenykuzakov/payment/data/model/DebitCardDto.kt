package ru.evgenykuzakov.payment.data.model


import kotlinx.serialization.Serializable

@Serializable
data class DebitCardDto(
    val cvv: String,
    val expireDate: String,
    val pan: String
)