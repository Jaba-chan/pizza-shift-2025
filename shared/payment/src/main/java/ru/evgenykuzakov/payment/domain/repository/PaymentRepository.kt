package ru.evgenykuzakov.payment.domain.repository

import ru.evgenykuzakov.payment.domain.model.Order
import ru.evgenykuzakov.payment.domain.model.param.PayCartParam

interface PaymentRepository {

    suspend fun payForCart(param: PayCartParam): Order

}