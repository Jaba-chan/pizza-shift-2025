package ru.evgenykuzakov.auth.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.evgenykuzakov.auth.domain.model.params.OtpParams
import ru.evgenykuzakov.auth.domain.model.params.SignInParams
import ru.evgenykuzakov.auth.domain.use_case.RequestOtpUseCase
import ru.evgenykuzakov.auth.domain.use_case.SignInUseCase
import ru.evgenykuzakov.utils.Resource
import javax.inject.Inject

@HiltViewModel
class AuthScreenViewModel @Inject constructor(
    private val createOptUseCase: RequestOtpUseCase,
    private val signInUseCase: SignInUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(AuthScreenUIState())
    val uiState: StateFlow<AuthScreenUIState> = _uiState

    fun onPhoneTextChanged(text: String) {
        _uiState.update {
            it.copy(
                phone = text
            )
        }
    }

    fun onCodeTextChanged(text: String) {
        _uiState.update {
            it.copy(
                code = text
            )
        }
    }

    fun sendPhone() {
        viewModelScope.launch {
            createOptUseCase(
                params = OtpParams(
                    phone = _uiState.value.phone
                )
            ).collect { result ->
                if (result is Resource.Success)
                    _uiState.update {
                        it.copy(
                            isPhoneSent = true
                        )
                    }
            }
        }
    }

    fun sendCode() {
        viewModelScope.launch {
            signInUseCase(
                params = SignInParams(
                    phone = _uiState.value.phone,
                    code = _uiState.value.code.toInt()
                )
            ).collect {}
        }
    }
}