package ru.evgenykuzakov.payment.domain.model

import ru.evgenykuzakov.pizza.PizzaShort

data class Order(
    val cancellable: Boolean,
    val person: Person,
    val pizzas: List<PizzaShort>,
    val receiverAddress: ReceiverAddress,
    val status: Int,
    val totalPrice: Int
)
