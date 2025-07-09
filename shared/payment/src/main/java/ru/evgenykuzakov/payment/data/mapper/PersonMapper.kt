package ru.evgenykuzakov.payment.data.mapper

import ru.evgenykuzakov.payment.data.model.PersonDto
import ru.evgenykuzakov.payment.domain.model.Person

fun Person.toDto() = PersonDto(
    firstname = firstname,
    lastname = lastname,
    middlename = middlename,
    phone = phone
)

fun PersonDto.toDomain() = Person(
    firstname = firstname,
    lastname = lastname,
    middlename = middlename,
    phone = phone
)