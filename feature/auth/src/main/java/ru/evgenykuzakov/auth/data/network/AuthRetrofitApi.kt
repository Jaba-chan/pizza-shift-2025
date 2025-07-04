package ru.evgenykuzakov.auth.data.network

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import ru.evgenykuzakov.auth.data.model.request.OtpRequest
import ru.evgenykuzakov.auth.data.model.UserResponse
import ru.evgenykuzakov.auth.data.model.request.SignInRequest

interface AuthRetrofitApi {

    @POST("auth/otp")
    suspend fun requestOtp(@Body request: OtpRequest)

    @POST("users/signin")
    suspend fun signIn(@Body request: SignInRequest): UserResponse

    @GET("users/session")
    suspend fun getUserSession(): UserResponse

}