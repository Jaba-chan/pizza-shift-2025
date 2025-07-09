package ru.evgenykuzakov.payment.data.mapper

import ru.evgenykuzakov.payment.data.model.OrderDto
import ru.evgenykuzakov.payment.domain.model.Order

fun OrderDto.toDomain() = Order(
    cancellable = cancellable,
    person = person.toDomain(),
    pizzas = pizzas.map { it.toDomain() },
    receiverAddress = receiverAddress.toDomain(),
    status = status,
    totalPrice = totalPrice
)