package ru.evgenykuzakov.profile.data.repository

import ru.evgenykuzakov.profile.data.mapper.toDomain
import ru.evgenykuzakov.profile.data.mapper.toDto
import ru.evgenykuzakov.profile.data.network.ProfileRetrofitApi
import ru.evgenykuzakov.profile.domain.repository.ProfileRepository
import ru.evgenykuzakov.user.User
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val api: ProfileRetrofitApi
) : ProfileRepository {

    override suspend fun getSession(): User = api.getSession().user.toDomain()

    override suspend fun updateProfile(user: User): User = api.updateProfile(user.toDto()).user.toDomain()
}