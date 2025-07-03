package ru.evgenykuzakov.auth.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.evgenykuzakov.auth.data.AuthRepositoryImpl
import ru.evgenykuzakov.auth.domain.AuthRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    internal abstract fun bindsLocalUsersRepository(
        impl: AuthRepositoryImpl,
    ): AuthRepository

}