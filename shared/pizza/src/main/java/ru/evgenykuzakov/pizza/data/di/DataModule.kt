package ru.evgenykuzakov.pizza.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.evgenykuzakov.pizza.data.repository.PizzaRepositoryImpl
import ru.evgenykuzakov.pizza.domain.repository.PizzaRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    internal abstract fun bindsLocalUsersRepository(
        impl: PizzaRepositoryImpl,
    ): PizzaRepository

}