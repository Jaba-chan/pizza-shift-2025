package ru.evgenykuzakov.auth.data

import ru.evgenykuzakov.auth.data.model.toDomain
import ru.evgenykuzakov.auth.domain.AuthRepository
import ru.evgenykuzakov.auth.domain.model.User

class AuthRepositoryImpl(
    private val api: AuthRetrofitApi
) : AuthRepository {

    override suspend fun signIn(): User {
        return api.signIn().toDomain()
    }

    override suspend fun createOtp() {
       return api.createOtp()
    }

    override suspend fun getUserSession(): User {
        return api.getUserSession().toDomain()
    }
}