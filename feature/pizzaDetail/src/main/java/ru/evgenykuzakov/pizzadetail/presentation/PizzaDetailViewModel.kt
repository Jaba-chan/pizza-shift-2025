package ru.evgenykuzakov.pizzadetail.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.evgenykuzakov.cart.domain.use_case.AddToCartUseCase
import ru.evgenykuzakov.network.di.RetrofitBaseUrl
import ru.evgenykuzakov.pizza.domain.use_case.GetPizzaDetailInfoUseCase
import javax.inject.Inject

@HiltViewModel
class PizzaDetailViewModel @Inject constructor(
    @RetrofitBaseUrl private val baseUrl: String,
    private val getPizzaDetailInfoUseCase: GetPizzaDetailInfoUseCase
): ViewModel() {


    fun getBaseUrl() = baseUrl

    private val _uiState = MutableStateFlow<PizzaDetailScreenUIState>(PizzaDetailScreenUIState.Loading)
    val uiState: StateFlow<PizzaDetailScreenUIState> = _uiState

    private val handler = CoroutineExceptionHandler{ _, exception ->
        _uiState.value = PizzaDetailScreenUIState.Error(exception.localizedMessage.orEmpty())
    }

    init {
        viewModelScope.launch(handler) {
            val pizza = getPizzaDetailInfoUseCase("1")
            _uiState.value = PizzaDetailScreenUIState.Content(pizza)
        }

    }


}