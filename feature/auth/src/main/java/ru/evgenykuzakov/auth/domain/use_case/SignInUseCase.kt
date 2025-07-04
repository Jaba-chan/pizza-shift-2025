package ru.evgenykuzakov.auth.domain.use_case

import ru.evgenykuzakov.auth.domain.AuthRepository
import ru.evgenykuzakov.auth.domain.model.User
import ru.evgenykuzakov.auth.domain.model.params.SignInParams
import ru.evgenykuzakov.utils.Resource
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(params: SignInParams): Resource<User> {
        val user = repository.signIn(params)
        return if (user != null){
            Resource.Success(user)
        } else Resource.Error("NOT_CORRECT_OTP")
    }
}