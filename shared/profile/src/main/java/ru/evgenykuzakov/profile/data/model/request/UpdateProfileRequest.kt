package ru.evgenykuzakov.profile.data.model.request


import kotlinx.serialization.Serializable
import ru.evgenykuzakov.profile.data.model.Profile

@Serializable
data class UpdateProfileRequest(
    val phone: String,
    val profile: Profile
)