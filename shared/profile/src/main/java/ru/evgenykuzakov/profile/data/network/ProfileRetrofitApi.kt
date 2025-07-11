package ru.evgenykuzakov.profile.data.network

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import ru.evgenykuzakov.profile.data.model.SessionResponse
import ru.evgenykuzakov.profile.data.model.request.UpdateProfileRequest

interface ProfileRetrofitApi {

    @GET("users/session")
    suspend fun getSession(): SessionResponse

    @PATCH("users/profile")
    suspend fun updateProfile(@Body request: UpdateProfileRequest): SessionResponse

}