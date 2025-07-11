package ru.evgenykuzakov.cart.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.evgenykuzakov.cart.domain.use_case.AddOneToCartUseCase
import ru.evgenykuzakov.cart.domain.use_case.DeleteOneFromCartUseCase
import ru.evgenykuzakov.cart.domain.use_case.GetCartUseCase
import ru.evgenykuzakov.pizza.Pizza
import ru.evgenykuzakov.network.di.RetrofitBaseUrl
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    @RetrofitBaseUrl private val baseUrl: String,
    private val getCartUseCase: GetCartUseCase,
    private val deleteOneFromCartUseCase: DeleteOneFromCartUseCase,
    private val addOneToCartUseCase: AddOneToCartUseCase
) : ViewModel() {

    fun getBaseUrl() = baseUrl

    private val _uiState =
        MutableStateFlow<CartScreenUIState>(CartScreenUIState.Loading)
    val uiState: StateFlow<CartScreenUIState> = _uiState

    private val handler = CoroutineExceptionHandler { _, exception ->
        _uiState.value = CartScreenUIState.Error(exception.localizedMessage.orEmpty())
    }

    init {
        updateCart()
    }

    private fun updateCart(){
        _uiState.value = CartScreenUIState.Loading
        viewModelScope.launch(handler + Dispatchers.IO) {
            getCartUseCase.invoke().collect {cart ->
                _uiState.value = CartScreenUIState.Content(cart)
            }
        }
    }

    fun addOne(pizza: Pizza) {
        viewModelScope.launch(Dispatchers.IO) {
            addOneToCartUseCase.invoke(pizza)
        }

    }

    fun deleteOne(pizza: Pizza) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteOneFromCartUseCase.invoke(pizza)
        }
    }

}