package ru.evgenykuzakov.pizza.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import ru.evgenykuzakov.pizza.data.network.PizzaRetrofitApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Provides
    @Singleton
    fun provideAuthRetrofitApi(
        retrofit: Retrofit,
    ): PizzaRetrofitApi {
        return retrofit.create(PizzaRetrofitApi::class.java)
    }

}