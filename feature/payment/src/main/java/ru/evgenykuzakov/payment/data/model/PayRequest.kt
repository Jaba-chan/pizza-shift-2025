package ru.evgenykuzakov.payment.data.model

import kotlinx.serialization.Serializable


@Serializable
data class PayRequest(
    val debitCard: DebitCardDto,
    val person: PersonDto,
    val pizzas: List<PizzaDto>,
    val receiverAddress: ReceiverAddressDto
)