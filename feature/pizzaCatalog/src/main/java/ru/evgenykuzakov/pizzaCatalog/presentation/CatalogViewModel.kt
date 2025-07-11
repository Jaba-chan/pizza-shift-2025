package ru.evgenykuzakov.pizzaCatalog.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.evgenykuzakov.network.di.RetrofitBaseUrl
import ru.evgenykuzakov.pizza.domain.use_case.GetCatalogUseCase
import javax.inject.Inject

@HiltViewModel
class CatalogViewModel @Inject constructor(
    private val getCatalogUseCase: GetCatalogUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow<CatalogScreenUIState>(CatalogScreenUIState.Loading)
    val uiState: StateFlow<CatalogScreenUIState> = _uiState

    private val handler = CoroutineExceptionHandler{ _, exception ->
        _uiState.value = CatalogScreenUIState.Error(exception.localizedMessage.orEmpty())
    }

    fun getCatalog(){
        viewModelScope.launch(handler) {
            _uiState.value = CatalogScreenUIState.Content(getCatalogUseCase.invoke())
        }
    }
}