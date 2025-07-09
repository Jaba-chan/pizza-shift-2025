package ru.evgenykuzakov.profile.domain.use_case

import ru.evgenykuzakov.profile.domain.repository.ProfileRepository
import ru.evgenykuzakov.user.User
import javax.inject.Inject

class GetProfileUseCase @Inject constructor(
    private val repository: ProfileRepository
) : suspend () -> User by repository::getSession
