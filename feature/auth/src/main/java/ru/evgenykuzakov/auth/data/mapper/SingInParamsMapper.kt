package ru.evgenykuzakov.auth.data.mapper

import ru.evgenykuzakov.auth.data.model.request.OtpRequest
import ru.evgenykuzakov.auth.data.model.request.SignInRequest
import ru.evgenykuzakov.auth.domain.model.params.SignInParams

fun SignInParams.toDto() = SignInRequest(
    phone = phone,
    code = code
)