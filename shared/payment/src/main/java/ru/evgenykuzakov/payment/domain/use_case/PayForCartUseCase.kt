package ru.evgenykuzakov.payment.domain.use_case

import ru.evgenykuzakov.payment.domain.model.Order
import ru.evgenykuzakov.payment.domain.model.param.PayCartParam
import ru.evgenykuzakov.payment.domain.repository.PaymentRepository
import javax.inject.Inject

class PayForCartUseCase @Inject constructor(
    private val repository: PaymentRepository
) : suspend (PayCartParam) -> Order by repository::payForCart