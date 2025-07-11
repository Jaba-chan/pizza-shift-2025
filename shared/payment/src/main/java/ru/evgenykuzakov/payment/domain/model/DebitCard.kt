package ru.evgenykuzakov.payment.domain.model

data class DebitCard(
    val cvv: String,
    val expireDate: String,
    val pan: String
)