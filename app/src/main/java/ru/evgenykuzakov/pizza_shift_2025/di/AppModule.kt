package ru.evgenykuzakov.pizza_shift_2025.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.evgenykuzakov.network.di.RetrofitBaseUrl
import ru.evgenykuzakov.pizza_shift_2025.BuildConfig

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @RetrofitBaseUrl
    fun provideRetrofitBaseUrl(): String = BuildConfig.BASE_API_URL

}