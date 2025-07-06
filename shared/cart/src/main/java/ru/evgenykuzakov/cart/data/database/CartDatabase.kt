package ru.evgenykuzakov.cart.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.evgenykuzakov.cart.data.database.converter.PizzaTypeConverter
import ru.evgenykuzakov.cart.data.database.dao.CartDao
import ru.evgenykuzakov.cart.data.database.model.PizzaEntity

@Database(
    entities = [PizzaEntity::class],
    version = 1
)
@TypeConverters(
    PizzaTypeConverter::class
)
abstract class CartDatabase: RoomDatabase() {
    abstract fun cartDao(): CartDao
}