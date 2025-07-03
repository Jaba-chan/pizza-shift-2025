package ru.evgenykuzakov.auth.data.mapper

import ru.evgenykuzakov.auth.data.model.request.OtpRequest
import ru.evgenykuzakov.auth.domain.model.params.OtpParams

fun OtpParams.toDto() = OtpRequest(
    phone = phone
)