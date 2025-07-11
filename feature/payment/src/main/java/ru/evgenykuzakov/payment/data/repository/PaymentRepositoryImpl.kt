package ru.evgenykuzakov.payment.data.repository

import ru.evgenykuzakov.payment.data.mapper.toDomain
import ru.evgenykuzakov.payment.data.mapper.toRequest
import ru.evgenykuzakov.payment.data.network.PaymentRetrofitApi
import ru.evgenykuzakov.payment.domain.model.Order
import ru.evgenykuzakov.payment.domain.model.PayCartParam
import ru.evgenykuzakov.payment.domain.repository.PaymentRepository
import javax.inject.Inject

class PaymentRepositoryImpl @Inject constructor(
    private val api: PaymentRetrofitApi,
) : PaymentRepository {

    override suspend fun payForCart(param: PayCartParam): Order = api.payForCart(param.toRequest()).order.toDomain()
}