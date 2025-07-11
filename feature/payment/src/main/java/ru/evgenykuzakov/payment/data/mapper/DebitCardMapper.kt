package ru.evgenykuzakov.payment.data.mapper

import ru.evgenykuzakov.payment.data.model.DebitCardDto
import ru.evgenykuzakov.payment.domain.model.DebitCard

fun DebitCard.toDto() = DebitCardDto(
    cvv = cvv,
    expireDate = expireDate,
    pan = pan
)