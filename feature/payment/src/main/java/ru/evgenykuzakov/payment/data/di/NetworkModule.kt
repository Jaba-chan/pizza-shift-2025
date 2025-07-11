package ru.evgenykuzakov.payment.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Provides
    @Singleton
    fun providePaymentRetrofitApi(
        retrofit: Retrofit,
    ): ru.evgenykuzakov.payment.data.network.PaymentRetrofitApi {
        return retrofit.create(ru.evgenykuzakov.payment.data.network.PaymentRetrofitApi::class.java)
    }

}