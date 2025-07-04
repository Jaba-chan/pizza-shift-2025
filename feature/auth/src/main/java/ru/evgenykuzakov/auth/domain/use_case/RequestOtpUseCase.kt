package ru.evgenykuzakov.auth.domain.use_case

import ru.evgenykuzakov.auth.domain.AuthRepository
import ru.evgenykuzakov.auth.domain.model.params.OtpParams
import javax.inject.Inject

class RequestOtpUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(params: OtpParams): Unit = repository.requestOtp(params)

}