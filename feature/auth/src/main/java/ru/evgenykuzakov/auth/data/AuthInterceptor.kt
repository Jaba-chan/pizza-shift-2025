package ru.evgenykuzakov.auth.data

import okhttp3.Interceptor
import okhttp3.Response

internal class AuthInterceptor(
    private val optTokenStorage: OptTokenDataSource
): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val token = optTokenStorage.authToken

        val authorizedRequest = request.newBuilder()
            .header("Authorization", "Bearer $token")
            .build()
        return chain.proceed(authorizedRequest)
    }
}