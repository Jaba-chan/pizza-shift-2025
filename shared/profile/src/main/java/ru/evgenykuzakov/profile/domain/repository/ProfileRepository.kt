package ru.evgenykuzakov.profile.domain.repository

import ru.evgenykuzakov.user.User

interface ProfileRepository {

    suspend fun getSession(): User

    suspend fun updateProfile(user: User): User

}