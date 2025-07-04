package ru.evgenykuzakov.auth.domain

import ru.evgenykuzakov.auth.domain.model.params.OtpParams
import ru.evgenykuzakov.auth.domain.model.User
import ru.evgenykuzakov.auth.domain.model.params.SignInParams

interface AuthRepository {

    suspend fun signIn(params: SignInParams): User

    suspend fun requestOtp(params: OtpParams)

    suspend fun getUserSession(): User
}