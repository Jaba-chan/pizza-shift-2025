package ru.evgenykuzakov.payment.data.model


import kotlinx.serialization.Serializable

@Serializable
data class OrderDto(
    val cancellable: Boolean,
    val person: PersonDto,
    val pizzas: List<PizzaDto>,
    val receiverAddress: ReceiverAddressDto,
    val status: Int,
    val totalPrice: Int
)