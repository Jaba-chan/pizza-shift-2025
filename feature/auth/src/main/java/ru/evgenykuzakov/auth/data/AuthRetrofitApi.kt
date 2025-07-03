package ru.evgenykuzakov.auth.data

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import ru.evgenykuzakov.auth.data.model.request.OtpRequest
import ru.evgenykuzakov.auth.data.model.UserDto
import ru.evgenykuzakov.auth.data.model.request.SignInRequest

interface AuthRetrofitApi {

    @POST("auth/otp")
    suspend fun createOtp(@Body request: OtpRequest)

    @POST("users/signin")
    suspend fun signIn(@Body request: SignInRequest): UserDto

    @GET("users/session")
    suspend fun getUserSession(): UserDto

}