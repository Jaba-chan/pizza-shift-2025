package ru.evgenykuzakov.profile.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.evgenykuzakov.profile.data.repository.ProfileRepositoryImpl
import ru.evgenykuzakov.profile.domain.repository.ProfileRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    internal abstract fun bindsProfileRepository(
        impl: ProfileRepositoryImpl,
    ): ProfileRepository

}