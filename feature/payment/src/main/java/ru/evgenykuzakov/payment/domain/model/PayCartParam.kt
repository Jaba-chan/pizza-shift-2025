package ru.evgenykuzakov.payment.domain.model

import ru.evgenykuzakov.pizza.PizzaShort

data class PayCartParam(
    val receiverAddress: ReceiverAddress,
    val person: Person,
    val debitCard: DebitCard,
    val pizzas: List<PizzaShort>
)
