package ru.evgenykuzakov.auth.data.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.evgenykuzakov.auth.data.datastore.OptTokenDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatastoreModule {

    @Provides
    @Singleton
    fun provideOptTokenStorage(
        @ApplicationContext context: Context
    ): OptTokenDataSource {
        return OptTokenDataSource(context)
    }

}