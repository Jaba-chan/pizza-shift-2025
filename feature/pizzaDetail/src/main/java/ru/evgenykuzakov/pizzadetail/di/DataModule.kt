package ru.evgenykuzakov.pizzadetail.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.evgenykuzakov.cart.data.repository.CartRepositoryImpl
import ru.evgenykuzakov.cart.domain.repository.CartRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    internal abstract fun bindsCartRepository(
        impl: CartRepositoryImpl
    ): CartRepository

}