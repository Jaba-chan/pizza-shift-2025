package ru.evgenykuzakov.profile.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import ru.evgenykuzakov.otptoken.OptTokenDataSource
import ru.evgenykuzakov.profile.data.network.AuthInterceptor
import ru.evgenykuzakov.profile.data.network.ProfileRetrofitApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Provides
    @Singleton
    fun provideAuthInterceptor(
        optTokenStorage: OptTokenDataSource
    ): AuthInterceptor {
        return AuthInterceptor(optTokenStorage)
    }

    @Provides
    @Singleton
    fun provideHttpClient(
        authInterceptor: AuthInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder().apply {
            addInterceptor(
                HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
                }
            )
            addInterceptor(authInterceptor)
        }.build()
    }

    @Provides
    @Singleton
    fun provideProfileRetrofitApi(
        retrofit: Retrofit,
    ): ProfileRetrofitApi {
        return retrofit.create(ProfileRetrofitApi::class.java)
    }

}