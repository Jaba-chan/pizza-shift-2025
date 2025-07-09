package ru.evgenykuzakov.payment.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.evgenykuzakov.profile.domain.use_case.GetProfileUseCase
import ru.evgenykuzakov.profile.domain.use_case.UpdateProfileUseCase
import ru.evgenykuzakov.user.User
import javax.inject.Inject

@HiltViewModel
class PaymentViewModel @Inject constructor(
    private val getProfileUseCase: GetProfileUseCase,
    private val updateProfileUseCase: UpdateProfileUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<PaymentScreenUIState>(PaymentScreenUIState.Loading)
    val uiState: StateFlow<PaymentScreenUIState> = _uiState

    private val handler = CoroutineExceptionHandler { _, exception ->
        _uiState.value = PaymentScreenUIState.Error(exception.localizedMessage.orEmpty())
    }

    init {
        viewModelScope.launch(Dispatchers.IO + handler) {
            _uiState.value = PaymentScreenUIState.Content(getProfileUseCase.invoke())
        }

    }

    private fun updateUser(update: (User) -> User) {
        _uiState.update {
            if (it is PaymentScreenUIState.Content) {
                it.copy(user = update(it.user))
            } else it
        }
    }

    fun handleFirstNameTextInput(text: String) {
        updateUser { it.copy(firstname = text) }
    }

    fun handleLastNameTextInput(text: String) {
        updateUser { it.copy(lastname = text) }
    }

    fun handlePhoneTextInput(text: String) {
        updateUser { it.copy(phone = text) }
    }

    fun handleEmailTextInput(text: String) {
        updateUser { it.copy(email = text) }
    }

    fun handleCityTextInput(text: String) {
        updateUser { it.copy(city = text) }
    }

}