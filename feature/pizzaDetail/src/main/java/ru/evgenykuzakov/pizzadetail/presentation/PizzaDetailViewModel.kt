package ru.evgenykuzakov.pizzadetail.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.evgenykuzakov.cart.domain.use_case.AddToCartUseCase
import ru.evgenykuzakov.model.pizza.Ingredient
import ru.evgenykuzakov.model.pizza.Pizza
import ru.evgenykuzakov.network.di.RetrofitBaseUrl
import ru.evgenykuzakov.pizza.domain.use_case.GetPizzaDetailInfoUseCase
import javax.inject.Inject

@HiltViewModel
class PizzaDetailViewModel @Inject constructor(
    @RetrofitBaseUrl private val baseUrl: String,
    private val getPizzaDetailInfoUseCase: GetPizzaDetailInfoUseCase,
    private val addToCartUseCase: AddToCartUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val pizzaId: String = savedStateHandle["pizzaId"]!!

    fun getBaseUrl() = baseUrl

    private val _uiState =
        MutableStateFlow<PizzaDetailScreenUIState>(PizzaDetailScreenUIState.Loading)
    val uiState: StateFlow<PizzaDetailScreenUIState> = _uiState

    private val handler = CoroutineExceptionHandler { _, exception ->
        println(exception)
        _uiState.value = PizzaDetailScreenUIState.Error(exception.localizedMessage.orEmpty())
    }

    init {
        viewModelScope.launch(Dispatchers.IO + handler) {
            val pizza = getPizzaDetailInfoUseCase(pizzaId)
            _uiState.value = PizzaDetailScreenUIState.Content(
                pizza = pizza,
                userChoice = Pizza(
                    id = pizza.id,
                    name = pizza.name,
                    img = pizza.img,
                    toppings = emptyList(),
                    size = pizza.sizes.first(),
                    dough = pizza.doughs.first()
                )
            )
        }
    }

    fun addToCart() {
        viewModelScope.launch(Dispatchers.IO) {
            addToCartUseCase((_uiState.value as PizzaDetailScreenUIState.Content).userChoice)
        }
    }

    fun selectPizzaSize(pos: Int) {
        val currentState = _uiState.value as PizzaDetailScreenUIState.Content
        val updatedUserChoice = currentState.userChoice.copy(
            size = currentState.pizza.sizes[pos]
        )
        _uiState.value = currentState.copy(userChoice = updatedUserChoice)
    }

    fun selectExtraIngredient(ingredient: Ingredient) {
        val currentState = _uiState.value as PizzaDetailScreenUIState.Content
        val toppings = currentState.userChoice.toppings
        val updatedUserChoice = currentState.userChoice.copy(
            toppings = toppings.let {
                if (ingredient in toppings) it.minus(ingredient) else it.plus(
                    ingredient
                )
            }.sortedBy { it.type.name }
        )
        _uiState.value = currentState.copy(userChoice = updatedUserChoice)
    }

    fun selectPizzaDough(pos: Int) {
        val currentState = _uiState.value as PizzaDetailScreenUIState.Content
        val updatedUserChoice = currentState.userChoice.copy(
            dough = currentState.pizza.doughs[pos]
        )
        _uiState.value = currentState.copy(userChoice = updatedUserChoice)
    }

    fun totalCost(): Int {
        val userChoice = (_uiState.value as PizzaDetailScreenUIState.Content).userChoice
        return userChoice.size.price + userChoice.dough.price + userChoice.toppings.sumOf { it.price }
    }
}