package ru.evgenykuzakov.auth.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
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

    private val _action = Channel<AuthActions>(Channel.BUFFERED)
    val action = _action.receiveAsFlow()

    private var timerJob: Job? = null

    fun handlePhoneTextInput(text: String) {
        _uiState.update { it.copy(phone = text) }
    }

    fun handleCodeTextInput(text: String) {
        if (_uiState.value.codeState?.codeStatus !is SentState.Loading)
            _uiState.update { it.copy(codeState = it.codeState?.copy(code = text)) }
    }

    private val sendPhoneHandler = CoroutineExceptionHandler { _, exception ->
        _uiState.update { it.copy(phoneStatus = SentState.Error(exception.localizedMessage.orEmpty())) }
    }

    fun auth() {
        if (_uiState.value.phoneStatus is SentState.Loading) return
        _uiState.update { it.copy(phoneStatus = SentState.Loading) }
        requestOtp()
    }

    private fun requestOtp() {
        startTimer()
        viewModelScope.launch(sendPhoneHandler) {
            createOptUseCase(OtpParams(phone = _uiState.value.phone))
            _uiState.update {
                it.copy(
                    phoneStatus = SentState.Idle,
                    codeState = CodeState(code = "", codeStatus = SentState.Idle)
                )
            }
        }
    }

    private val handler = CoroutineExceptionHandler { _, exception ->
        _uiState.update {
            it.copy(
                codeState = it.codeState?.copy(
                    codeStatus = SentState.Error(
                        exception.localizedMessage.orEmpty()
                    )
                )
            )
        }
    }

    fun signIn() {
        val currentState = _uiState.value
        if (currentState.codeState?.codeStatus is SentState.Loading) return

        _uiState.update { it.copy(codeState = currentState.codeState?.copy(codeStatus = SentState.Loading)) }
        viewModelScope.launch(handler) {
            val status = signInUseCase(
                SignInParams(
                    phone = currentState.phone,
                    code = currentState.codeState?.code?.toIntOrNull() ?: 0
                )
            )
            if (status is Resource.Success){
                _action.send(AuthActions.NavigateToCatalogScreen)
            }
            _uiState.update { it.copy(codeState = currentState.codeState?.copy(codeStatus = SentState.Idle)) }

        }
    }

    private fun startTimer(duration: Int = 60) {
        _uiState.update { it.copy(codeState = it.codeState?.copy(showResendCodeButton = false)) }
        timerJob?.cancel()
        timerJob = viewModelScope.launch {
            for (i in duration downTo 0) {
                delay(1000)
                _uiState.update { it.copy(codeState = it.codeState?.copy(timer = i)) }
            }
            _uiState.update { it.copy(codeState = it.codeState?.copy(timer = null)) }
            _uiState.update { it.copy(codeState = it.codeState?.copy(showResendCodeButton = true)) }
        }
    }

    fun requestCodeAgain() {
        requestOtp()
    }
}