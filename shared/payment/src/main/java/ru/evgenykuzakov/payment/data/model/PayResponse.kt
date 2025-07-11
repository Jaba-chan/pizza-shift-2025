package ru.evgenykuzakov.payment.data.model


import kotlinx.serialization.Serializable

@Serializable
data class PayResponse(
    val order: OrderDto,
    val reason: String?,
    val success: Boolean
)