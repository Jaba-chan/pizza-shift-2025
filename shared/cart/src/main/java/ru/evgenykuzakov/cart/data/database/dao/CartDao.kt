package ru.evgenykuzakov.cart.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.evgenykuzakov.cart.data.database.model.CartItemEntity
import ru.evgenykuzakov.cart.data.database.model.PizzaEntity

@Dao
interface CartDao {

    @Query("""
        SELECT *, COUNT(*) AS count FROM cart GROUP BY 
        pizzaId, toppings, size, dough
    """)
    fun getCart(): List<CartItemEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addToCart(pizza: PizzaEntity)

}