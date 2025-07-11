package ru.evgenykuzakov.profile.data.mapper

import ru.evgenykuzakov.profile.data.model.Profile
import ru.evgenykuzakov.profile.data.model.UserDto
import ru.evgenykuzakov.profile.data.model.request.UpdateProfileRequest
import ru.evgenykuzakov.user.User

fun UserDto.toDomain() = User(
    city = city ?: "",
    email = email,
    firstname = firstname ?: "",
    lastname = lastname ?: "",
    middlename = middlename,
    phone = phone
)

fun User.toDto() = UpdateProfileRequest(
    profile = Profile(
        city = city,
        email = email,
        firstname = firstname,
        lastname = lastname,
        middlename = middlename
    ),
    phone = phone
)
