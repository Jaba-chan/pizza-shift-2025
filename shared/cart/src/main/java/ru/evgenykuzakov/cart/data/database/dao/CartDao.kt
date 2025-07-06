package ru.evgenykuzakov.cart.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import ru.evgenykuzakov.cart.data.database.model.PizzaEntity

@Dao
interface CartDao {

    @Query("SELECT * from cart")
    fun getCart(): List<PizzaEntity>

}