package ru.evgenykuzakov.auth.data.model

import ru.evgenykuzakov.auth.domain.model.User

fun UserDto.toDomain() = User(
    city = city,
    email = email,
    firstname = firstname,
    lastname = lastname,
    middlename = middlename,
    phone = phone
)
