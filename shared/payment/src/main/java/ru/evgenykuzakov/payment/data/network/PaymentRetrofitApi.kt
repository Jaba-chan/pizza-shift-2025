package ru.evgenykuzakov.payment.data.network

import retrofit2.http.Body
import retrofit2.http.POST
import ru.evgenykuzakov.payment.data.model.PayRequest
import ru.evgenykuzakov.payment.data.model.PayResponse

interface PaymentRetrofitApi {

    @POST
    suspend fun payForCart(@Body payRequest: PayRequest): PayResponse

}