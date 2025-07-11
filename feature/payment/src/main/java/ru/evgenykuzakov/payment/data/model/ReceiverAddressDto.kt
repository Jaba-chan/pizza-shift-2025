package ru.evgenykuzakov.payment.data.model

import kotlinx.serialization.Serializable


@Serializable
data class ReceiverAddressDto(
    val apartment: String,
    val comment: String?,
    val house: String,
    val street: String
)