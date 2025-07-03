package ru.evgenykuzakov.auth.data.mapper

import ru.evgenykuzakov.auth.data.model.UserDto
import ru.evgenykuzakov.auth.domain.model.User

fun UserDto.toDomain() = User(
    city = city,
    email = email,
    firstname = firstname,
    lastname = lastname,
    middlename = middlename,
    phone = phone
)
