package ru.evgenykuzakov.payment.data.model

import kotlinx.serialization.Serializable


@Serializable
data class PersonDto(
    val firstname: String,
    val lastname: String,
    val middlename: String?,
    val phone: String
)