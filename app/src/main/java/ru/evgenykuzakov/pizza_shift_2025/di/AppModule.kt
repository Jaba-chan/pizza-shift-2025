package ru.evgenykuzakov.pizza_shift_2025.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.evgenykuzakov.network.di.RetrofitBaseUrl

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @RetrofitBaseUrl
    fun provideRetrofitBaseUrl(): String = "https://shift-intensive.ru/api/"

}