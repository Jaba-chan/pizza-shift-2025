package ru.evgenykuzakov.cart.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import ru.evgenykuzakov.cart.data.database.model.PizzaEntity

@Dao
interface CartDao {

    @Query("SELECT * from cart")
    fun getCart(): List<PizzaEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addToCart(pizza: PizzaEntity)

}