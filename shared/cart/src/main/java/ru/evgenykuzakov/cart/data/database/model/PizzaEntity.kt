package ru.evgenykuzakov.cart.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart")
data class PizzaEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val pizzaId: String,
    val name: String,
    val img: String,
    val toppings: List<ToppingEntity>,
    val size: SizeEntity,
    val dough: DoughEntity
)