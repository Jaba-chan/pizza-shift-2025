package ru.evgenykuzakov.payment.data.model


import kotlinx.serialization.Serializable
import ru.evgenykuzakov.pizza.data.model.CatalogDto

@Serializable
data class OrderDto(
    val cancellable: Boolean,
    val person: PersonDto,
    val pizzas: List<CatalogDto>,
    val receiverAddress: ReceiverAddressDto,
    val status: Int,
    val totalPrice: Int
)