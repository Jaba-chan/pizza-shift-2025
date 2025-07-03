package ru.evgenykuzakov.auth.domain.use_case

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.evgenykuzakov.auth.domain.AuthRepository
import ru.evgenykuzakov.auth.domain.model.User
import ru.evgenykuzakov.auth.domain.model.params.SignInParams
import ru.evgenykuzakov.utils.Resource
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(params: SignInParams): Flow<Resource<User>> =
        flow {
            emit(Resource.Loading())
            emit(Resource.Success(repository.signIn(params)))
        }.catch { e ->
            println("SignInUseCase" + e.message)
            emit(Resource.Error(message = e.message))
        }.flowOn(Dispatchers.IO)
}