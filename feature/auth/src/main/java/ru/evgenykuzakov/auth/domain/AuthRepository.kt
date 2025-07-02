package ru.evgenykuzakov.auth.domain

import ru.evgenykuzakov.auth.domain.model.User

interface AuthRepository {

    suspend fun signIn(): User

    suspend fun createOtp()

    suspend fun getUserSession(): User
}