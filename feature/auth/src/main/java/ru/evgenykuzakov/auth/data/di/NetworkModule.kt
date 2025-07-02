package ru.evgenykuzakov.auth.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import ru.evgenykuzakov.auth.data.AuthInterceptor
import ru.evgenykuzakov.auth.data.AuthRetrofitApi
import ru.evgenykuzakov.auth.data.OptTokenStorage
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Provides
    @Singleton
    fun provideAuthInterceptor(
        optTokenStorage: OptTokenStorage
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