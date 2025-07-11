package ru.evgenykuzakov.payment.data.mapper

import ru.evgenykuzakov.payment.data.model.OrderDto
import ru.evgenykuzakov.payment.domain.model.Order
import ru.evgenykuzakov.pizza.data.mapper.toPizzaDetailInfo

fun OrderDto.toDomain() = Order(
    cancellable = cancellable,
    person = person.toDomain(),
    pizzas = pizzas.map { it.toPizzaDetailInfo() },
    receiverAddress = receiverAddress.toDomain(),
    status = status,
    totalPrice = totalPrice
)