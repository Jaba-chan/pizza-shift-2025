package ru.evgenykuzakov.payment.data.mapper

import ru.evgenykuzakov.payment.data.model.PayRequest
import ru.evgenykuzakov.payment.domain.model.PayCartParam

fun PayCartParam.toRequest(): PayRequest = PayRequest(
    debitCard = debitCard.toDto(),
    person = person.toDto(),
    pizzas = pizzas.map { it.toDto() },
    receiverAddress = receiverAddress.toDto()
)