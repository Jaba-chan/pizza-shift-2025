package ru.evgenykuzakov.auth.domain.use_case

import ru.evgenykuzakov.auth.domain.AuthRepository
import ru.evgenykuzakov.auth.domain.model.User
import ru.evgenykuzakov.auth.domain.model.params.SignInParams
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(params: SignInParams): User = repository.signIn(params)
}