package ru.evgenykuzakov.payment.domain.model

data class ReceiverAddress(
    val apartment: String,
    val comment: String?,
    val house: String,
    val street: String
)