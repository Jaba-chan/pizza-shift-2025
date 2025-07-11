package ru.evgenykuzakov.payment.domain.model

import ru.evgenykuzakov.pizza.domain.model.PizzaDetailInfo

data class Order(
    val cancellable: Boolean,
    val person: Person,
    val pizzas: List<PizzaDetailInfo>,
    val receiverAddress: ReceiverAddress,
    val status: Int,
    val totalPrice: Int
)
