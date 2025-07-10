package ru.evgenykuzakov.payment.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.evgenykuzakov.payment.data.repository.PaymentRepositoryImpl
import ru.evgenykuzakov.payment.domain.repository.PaymentRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    internal abstract fun bindsPaymentRepository(
        impl: PaymentRepositoryImpl,
    ): PaymentRepository

}