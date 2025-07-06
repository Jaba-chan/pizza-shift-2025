package ru.evgenykuzakov.cart.data.database.converter

import androidx.room.TypeConverter
import kotlinx.serialization.json.Json
import ru.evgenykuzakov.cart.data.database.model.DoughEntity
import ru.evgenykuzakov.cart.data.database.model.SizeEntity
import ru.evgenykuzakov.cart.data.database.model.ToppingEntity

class PizzaTypeConverter {
    private val json = Json { ignoreUnknownKeys = true}

    @TypeConverter fun fromSize(value: SizeEntity): String = json.encodeToString(value)
    @TypeConverter fun toSize(value: String): SizeEntity = json.decodeFromString(value)

    @TypeConverter fun fromTopping(value: ToppingEntity): String = json.encodeToString(value)
    @TypeConverter fun toTopping(value: String): ToppingEntity = json.decodeFromString(value)

    @TypeConverter fun fromDough(value: DoughEntity): String = json.encodeToString(value)
    @TypeConverter fun toDough(value: String): DoughEntity = json.decodeFromString(value)
}