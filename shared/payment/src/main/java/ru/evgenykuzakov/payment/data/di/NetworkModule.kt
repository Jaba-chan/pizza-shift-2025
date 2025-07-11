package ru.evgenykuzakov.payment.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import ru.evgenykuzakov.payment.data.network.PaymentRetrofitApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Provides
    @Singleton
    fun providePaymentRetrofitApi(
        retrofit: Retrofit,
    ): PaymentRetrofitApi {
        return retrofit.create(PaymentRetrofitApi::class.java)
    }

}