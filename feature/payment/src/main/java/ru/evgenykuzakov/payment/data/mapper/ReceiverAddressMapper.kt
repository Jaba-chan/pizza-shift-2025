package ru.evgenykuzakov.payment.data.mapper

import ru.evgenykuzakov.payment.data.model.ReceiverAddressDto
import ru.evgenykuzakov.payment.domain.model.ReceiverAddress

fun ReceiverAddress.toDto() = ReceiverAddressDto(
    apartment = apartment,
    house = house,
    street = street,
    comment = comment
)

fun ReceiverAddressDto.toDomain() = ReceiverAddress(
    apartment = apartment,
    house = house,
    street = street,
    comment = comment
)