package ru.evgenykuzakov.auth.domain.use_case

import ru.evgenykuzakov.auth.domain.AuthRepository
import ru.evgenykuzakov.auth.domain.model.User
import javax.inject.Inject

class GetUserSessionUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(): User = repository.getUserSession()
}