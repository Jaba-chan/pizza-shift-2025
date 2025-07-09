package ru.evgenykuzakov.pizza_shift_2025.di.cartModule

import android.content.Context
import android.util.Log
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.evgenykuzakov.cart.data.database.CartDatabase
import ru.evgenykuzakov.cart.data.database.dao.CartDao
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideCartDatabase(
        @ApplicationContext context: Context,
    ): CartDatabase = Room.databaseBuilder(
        context,
        CartDatabase::class.java,
        "cart_db"
    ).build()

    @Provides
    @Singleton
    fun provideCartDao(
        database: CartDatabase
    ): CartDao {
        return database.cartDao()
    }

}