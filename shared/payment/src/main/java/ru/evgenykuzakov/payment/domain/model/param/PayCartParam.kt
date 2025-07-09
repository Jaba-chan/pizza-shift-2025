package ru.evgenykuzakov.payment.domain.model.param

import ru.evgenykuzakov.payment.domain.model.DebitCard
import ru.evgenykuzakov.payment.domain.model.Person
import ru.evgenykuzakov.payment.domain.model.ReceiverAddress
import ru.evgenykuzakov.pizza.PizzaShort

data class PayCartParam(
    val receiverAddress: ReceiverAddress,
    val person: Person,
    val debitCard: DebitCard,
    val pizzas: List<PizzaShort>
)
