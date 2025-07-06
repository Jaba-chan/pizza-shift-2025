package ru.evgenykuzakov.pizza.data.network

import retrofit2.http.GET
import ru.evgenykuzakov.pizza.data.model.PizzaResponse

interface PizzaRetrofitApi {

    @GET("pizza/catalog")
    suspend fun getCatalog(): PizzaResponse

}