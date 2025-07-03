package ru.evgenykuzakov.auth.domain.use_case

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.evgenykuzakov.auth.domain.AuthRepository
import ru.evgenykuzakov.auth.domain.model.params.OtpParams
import ru.evgenykuzakov.utils.Resource
import javax.inject.Inject

class RequestOtpUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(params: OtpParams): Flow<Resource<Unit>> =
        flow {
            emit(Resource.Loading())
            emit(Resource.Success(repository.createOtp(params)))
        }.catch { e ->
            println("CreateOptUseCase" + e.message)
            emit(Resource.Error(message = e.message))
        }.flowOn(Dispatchers.IO)
}