package ru.evgenykuzakov.payment.domain.repository

import ru.evgenykuzakov.payment.domain.model.Order
import ru.evgenykuzakov.payment.domain.model.PayCartParam

interface PaymentRepository {

    suspend fun payForCart(param: PayCartParam): Order

}