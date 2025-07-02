package ru.evgenykuzakov.auth.data

import retrofit2.http.GET
import retrofit2.http.POST
import ru.evgenykuzakov.auth.data.model.UserDto

interface AuthRetrofitApi {

    @POST("auth/otp")
    suspend fun createOtp()

    @POST("/users/signin")
    suspend fun signIn(): UserDto

    @GET("users/session")
    suspend fun getUserSession(): UserDto

}