package ru.evgenykuzakov.auth.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import ru.evgenykuzakov.auth.data.network.AuthRetrofitApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Provides
    @Singleton
    fun provideAuthRetrofitApi(
        retrofit: Retrofit,
    ): AuthRetrofitApi {
        return retrofit.create(AuthRetrofitApi::class.java)
    }

}