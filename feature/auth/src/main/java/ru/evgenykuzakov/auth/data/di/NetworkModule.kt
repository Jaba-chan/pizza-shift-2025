package ru.evgenykuzakov.auth.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import ru.evgenykuzakov.auth.data.AuthInterceptor
import ru.evgenykuzakov.auth.data.AuthRetrofitApi
import ru.evgenykuzakov.auth.data.OptTokenDataSource
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
            addInterceptor(authInterceptor)
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        }.build()
    }

    @Provides
    @Singleton
    fun provideAuthRetrofitApi(
        retrofit: Retrofit,
    ): AuthRetrofitApi {
        return retrofit.create(AuthRetrofitApi::class.java)
    }

}