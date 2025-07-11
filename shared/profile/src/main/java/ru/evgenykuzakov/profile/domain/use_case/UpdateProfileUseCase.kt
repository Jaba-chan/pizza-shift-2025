package ru.evgenykuzakov.profile.domain.use_case

import ru.evgenykuzakov.profile.domain.repository.ProfileRepository
import ru.evgenykuzakov.user.User
import javax.inject.Inject

class UpdateProfileUseCase @Inject constructor(
    private val repository: ProfileRepository
) : suspend (User) -> User by repository::updateProfile
