package ru.evgenykuzakov.profile.data.model


import kotlinx.serialization.Serializable

@Serializable
data class Profile(
    val city: String?,
    val email: String?,
    val firstname: String,
    val lastname: String,
    val middlename: String?
)