package ru.evgenykuzakov.auth.data.repository

import ru.evgenykuzakov.auth.data.mapper.toDomain
import ru.evgenykuzakov.auth.data.mapper.toDto
import ru.evgenykuzakov.auth.data.network.AuthRetrofitApi
import ru.evgenykuzakov.auth.domain.AuthRepository
import ru.evgenykuzakov.auth.domain.model.params.OtpParams
import ru.evgenykuzakov.auth.domain.model.User
import ru.evgenykuzakov.auth.domain.model.params.SignInParams
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val api: AuthRetrofitApi,
) : AuthRepository {

    override suspend fun signIn(params: SignInParams): User {
        return api.signIn(params.toDto()).toDomain()
    }

    override suspend fun createOtp(params: OtpParams) {
        return api.createOtp(request = params.toDto())
    }

    override suspend fun getUserSession(): User {
        return api.getUserSession().toDomain()
    }
}