package ru.evgenykuzakov.cart.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.evgenykuzakov.cart.data.database.CartDatabase

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {

    @Provides
    fun provideUsersDatabase(
        @ApplicationContext context: Context,
    ): CartDatabase = Room.databaseBuilder(
        context,
        CartDatabase::class.java,
        "cart_db"
    ).build()

}