package ru.evgenykuzakov.profile.presentation

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
import ru.evgenykuzakov.user.User
import javax.inject.Inject

@HiltViewModel
class ShowProfileScreenViewModel @Inject constructor(
    private val getProfileUseCase: GetProfileUseCase,
) : ViewModel() {

    private val _uiState =
        MutableStateFlow<ShowProfileScreenUIState>(ShowProfileScreenUIState.Loading)
    val uiState: StateFlow<ShowProfileScreenUIState> = _uiState

    private val handler = CoroutineExceptionHandler { _, exception ->
        _uiState.value = ShowProfileScreenUIState.Error(exception.localizedMessage.orEmpty())
    }

    fun getProfile() {
        viewModelScope.launch(Dispatchers.IO + handler) {
            _uiState.value = ShowProfileScreenUIState.Content(user = (getProfileUseCase.invoke()))
        }
    }

    private fun updateUser(update: (User) -> User) {
        _uiState.update {
            if (it is ShowProfileScreenUIState.Content) {
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

    fun handleMiddleNameTextInput(text: String) {
        updateUser { it.copy(middlename = text) }
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