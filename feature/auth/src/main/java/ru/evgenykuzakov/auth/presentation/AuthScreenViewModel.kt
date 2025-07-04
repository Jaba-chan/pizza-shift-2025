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
        println(_uiState.value.codeState?.codeStatus)
        if (_uiState.value.codeState?.codeStatus !is SentState.Loading)
            _uiState.update {
                it.copy(
                    codeState = it.codeState?.copy(code = text)
                )
            }
    }

    fun sendPhone() {
        val currentState = _uiState.value
        if (currentState.phoneStatus is SentState.Loading) return

        _uiState.update {
            it.copy(
                phoneStatus = SentState.Loading
            )
        }
        viewModelScope.launch {
            try {
                createOptUseCase(
                    params = OtpParams(phone = currentState.phone)
                )
                _uiState.update {
                    it.copy(
                        phoneStatus = SentState.Idle,
                        codeState = CodeState(code = "", SentState.Idle)
                    )
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(phoneStatus = SentState.Error(e.localizedMessage.orEmpty()))
                }
            }
        }
    }

    fun sendCode() {
        val currentState = _uiState.value
        if (currentState.codeState?.codeStatus is SentState.Loading) return

        _uiState.update {
            it.copy(
                codeState = currentState.codeState?.copy(
                    codeStatus = SentState.Loading
                )
            )
        }
        viewModelScope.launch {
            try {
                signInUseCase(
                    params = SignInParams(
                        phone = currentState.phone,
                        code = currentState.codeState?.code?.toIntOrNull() ?: 0
                    )
                )
                _uiState.update {
                    it.copy(
                        codeState = currentState.codeState?.copy(
                            codeStatus = SentState.Idle
                        )
                    )
                }
            } catch (e: Exception) {
                println(e.message)
                _uiState.update {
                    it.copy(
                        codeState = it.codeState?.copy(codeStatus = SentState.Error(e.localizedMessage.orEmpty()))
                    )
                }
            }
        }
    }
}