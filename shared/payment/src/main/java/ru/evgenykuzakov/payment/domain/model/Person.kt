package ru.evgenykuzakov.payment.domain.model

data class Person(
    val firstname: String,
    val lastname: String,
    val middlename: String?,
    val phone: String
)