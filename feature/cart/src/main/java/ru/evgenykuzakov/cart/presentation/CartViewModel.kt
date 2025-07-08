package ru.evgenykuzakov.cart.presentation

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
import ru.evgenykuzakov.cart.domain.use_case.GetCartUseCase
import ru.evgenykuzakov.model.pizza.Ingredient
import ru.evgenykuzakov.model.pizza.Pizza
import ru.evgenykuzakov.network.di.RetrofitBaseUrl
import ru.evgenykuzakov.pizza.domain.use_case.GetPizzaDetailInfoUseCase
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    @RetrofitBaseUrl private val baseUrl: String,
    private val getCartUseCase: GetCartUseCase,
) : ViewModel() {

    fun getBaseUrl() = baseUrl

    private val _uiState =
        MutableStateFlow<CartScreenUIState>(CartScreenUIState.Loading)
    val uiState: StateFlow<CartScreenUIState> = _uiState

    init {
        _uiState.value = CartScreenUIState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.value = CartScreenUIState.Content(getCartUseCase.invoke())
        }
    }
}