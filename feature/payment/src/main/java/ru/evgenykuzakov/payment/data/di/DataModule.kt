package ru.evgenykuzakov.payment.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    internal abstract fun bindsPaymentRepository(
        impl: ru.evgenykuzakov.payment.data.repository.PaymentRepositoryImpl,
    ): ru.evgenykuzakov.payment.domain.repository.PaymentRepository

}