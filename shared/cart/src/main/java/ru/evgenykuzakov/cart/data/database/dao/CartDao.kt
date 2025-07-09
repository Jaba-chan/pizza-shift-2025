package ru.evgenykuzakov.cart.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.RewriteQueriesToDropUnusedColumns
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow
import ru.evgenykuzakov.cart.data.database.model.CartItemEntity
import ru.evgenykuzakov.cart.data.database.model.DoughEntity
import ru.evgenykuzakov.cart.data.database.model.IngredientEntity
import ru.evgenykuzakov.cart.data.database.model.PizzaEntity
import ru.evgenykuzakov.cart.data.database.model.SizeEntity

@Dao
interface CartDao {

    @Query(
        """
        SELECT *, COUNT(*) AS count FROM cart GROUP BY 
        pizzaId, toppings, size, dough
    """
    )
    fun getCartAsFlow(): Flow<List<CartItemEntity>>

    @Query("SELECT COUNT(*) FROM cart")
    fun getCartSizeAsFlow(): Flow<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToCart(pizza: PizzaEntity)

    @Query(
        """
        SELECT * FROM cart WHERE pizzaId = :pizzaId AND size = :size 
        AND dough = :dough AND toppings = :toppings LIMIT 1
    """
    )
    suspend fun findOneInCart(
        pizzaId: String,
        size: SizeEntity,
        dough: DoughEntity,
        toppings: List<IngredientEntity>
    ): PizzaEntity?

    @Delete
    suspend fun deleteCartItem(item: PizzaEntity)

    @Transaction
    suspend fun deleteFromCart(
        pizzaId: String,
        size: SizeEntity,
        dough: DoughEntity,
        toppings: List<IngredientEntity>
    ){
        findOneInCart(pizzaId, size, dough, toppings)?.let { deleteCartItem(it) }
    }
}