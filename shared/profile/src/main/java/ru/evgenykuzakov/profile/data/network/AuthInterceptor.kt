package ru.evgenykuzakov.profile.data.network

import okhttp3.Interceptor
import okhttp3.Response
import ru.evgenykuzakov.otptoken.OptTokenDataSource

class AuthInterceptor(
    private val optTokenStorage: OptTokenDataSource
): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val token = optTokenStorage.getAuthToken()

        val authorizedRequest = request.newBuilder()
            .header("Authorization", "Bearer $token")
            .build()
        return chain.proceed(authorizedRequest)
    }
}