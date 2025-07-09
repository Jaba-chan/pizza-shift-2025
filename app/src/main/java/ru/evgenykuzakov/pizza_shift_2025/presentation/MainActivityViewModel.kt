package ru.evgenykuzakov.pizza_shift_2025.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.evgenykuzakov.cart.domain.use_case.GetCartSizeUseCase
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val getCartSizeUseCase: GetCartSizeUseCase
): ViewModel() {
    private val _uiState = MutableStateFlow(MainActivityUIState())
    val uiState: StateFlow<MainActivityUIState> = _uiState

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getCartSizeUseCase().collect { count ->
                println("MainActivityViewModel $count")
                _uiState.update {
                    it.copy(cartBadge = count)
                }
            }
        }
    }
}

