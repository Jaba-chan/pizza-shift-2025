package ru.evgenykuzakov.auth.data.repository

import ru.evgenykuzakov.auth.data.datastore.OptTokenDataSource
import ru.evgenykuzakov.auth.data.mapper.toDomain
import ru.evgenykuzakov.auth.data.mapper.toDto
import ru.evgenykuzakov.auth.data.network.AuthRetrofitApi
import ru.evgenykuzakov.auth.domain.AuthRepository
import ru.evgenykuzakov.auth.domain.model.params.OtpParams
import ru.evgenykuzakov.user.User
import ru.evgenykuzakov.auth.domain.model.params.SignInParams
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val api: AuthRetrofitApi,
    private val optTokenDataSource: OptTokenDataSource
) : AuthRepository {

    override suspend fun signIn(params: SignInParams): User? {
        val userResponse = api.signIn(params.toDto())
        userResponse.token.let {
            optTokenDataSource.setAuthToken(it)
        }
        return userResponse.user?.toDomain()
    }

    override suspend fun requestOtp(params: OtpParams) {
        return api.requestOtp(request = params.toDto())
    }

}