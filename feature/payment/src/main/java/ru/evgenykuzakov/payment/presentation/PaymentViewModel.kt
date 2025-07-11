package ru.evgenykuzakov.payment.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.evgenykuzakov.cart.domain.use_case.ClearCartUseCase
import ru.evgenykuzakov.cart.domain.use_case.GetCartUseCase
import ru.evgenykuzakov.payment.data.mapper.toPerson
import ru.evgenykuzakov.payment.data.mapper.toShort
import ru.evgenykuzakov.payment.domain.model.DebitCard
import ru.evgenykuzakov.payment.domain.model.ReceiverAddress
import ru.evgenykuzakov.payment.domain.model.param.PayCartParam
import ru.evgenykuzakov.payment.domain.use_case.PayForCartUseCase
import ru.evgenykuzakov.profile.domain.use_case.GetProfileUseCase
import ru.evgenykuzakov.profile.domain.use_case.UpdateProfileUseCase
import ru.evgenykuzakov.user.User
import ru.evgenykuzakov.utils.isValidExpiredDate
import javax.inject.Inject

@HiltViewModel
class PaymentViewModel @Inject constructor(
    private val getProfileUseCase: GetProfileUseCase,
    private val updateProfileUseCase: UpdateProfileUseCase,
    private val payForCartUseCase: PayForCartUseCase,
    private val getCartUseCase: GetCartUseCase,
    private val clearCartUseCase: ClearCartUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<PaymentScreenUIState>(PaymentScreenUIState.Loading)
    val uiState: StateFlow<PaymentScreenUIState> = _uiState

    private val handler = CoroutineExceptionHandler { _, exception ->
        _uiState.value = PaymentScreenUIState.Error(exception.localizedMessage.orEmpty())
    }

    fun getProfile(){
        viewModelScope.launch(Dispatchers.IO + handler) {
            _uiState.value = PaymentScreenUIState.Content(user = (getProfileUseCase.invoke()))
        }
    }

    private fun updateProfile() {
        val currentState = _uiState.value as? PaymentScreenUIState.Content ?: return
        viewModelScope.launch(Dispatchers.IO + handler) {
            updateProfileUseCase.invoke(currentState.user)
        }
    }

    private fun createOrder() {
        val currentState = _uiState.value as? PaymentScreenUIState.Content ?: return
        val address = currentState.user.city.split(", ")
        viewModelScope.launch(Dispatchers.IO + handler) {
            val cart = getCartUseCase.invoke().first()
            val orderResult = payForCartUseCase.invoke(
                PayCartParam(
                    person = currentState.user.toPerson(),
                    pizzas = cart.map { it.toShort() },
                    debitCard = currentState.debitCard!!,
                    receiverAddress = ReceiverAddress(
                        address[0],
                        address[1],
                        address[2],
                        address[3]
                    )
                )
            )
            clearCartUseCase()
            _uiState.update { state ->
                if (state is PaymentScreenUIState.Content) {
                    state.copy(order = orderResult)
                } else {
                    state
                }
            }
        }
    }

    private fun updateUser(update: (User) -> User) {
        _uiState.update {
            if (it is PaymentScreenUIState.Content) {
                it.copy(user = update(it.user))
            } else it
        }
    }

    private fun updateDebitCard(update: (DebitCard) -> DebitCard) {
        _uiState.update {
            if (it is PaymentScreenUIState.Content && it.debitCard != null) {
                it.copy(debitCard = update(it.debitCard))
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

    fun handlePan(text: String) {
        updateDebitCard { it.copy(pan = text) }
    }

    fun handleExpireDate(text: String) {
        updateDebitCard { it.copy(expireDate = text) }
    }

    fun handleCVV(text: String) {
        updateDebitCard { it.copy(cvv = text) }
    }

    fun nextStep() {
        val currentState = _uiState.value as? PaymentScreenUIState.Content ?: return
        when (currentState.step) {
            Step.One -> {
                if (currentState.user.lastname.isNotBlank()
                    && currentState.user.firstname.isNotBlank()
                    && (currentState.user.city.split(",").size == 4)
                ) {
                    updateProfile()
                    _uiState.update {
                        currentState.copy(
                            step = currentState.step.next(),
                            debitCard = DebitCard(
                                pan = "",
                                expireDate = "",
                                cvv = ""
                            )
                        )
                    }
                }
            }

            Step.Two -> {
                if (currentState.debitCard!!.pan.length == 16
                    && currentState.debitCard.expireDate.isValidExpiredDate()
                    && currentState.debitCard.cvv.length == 3
                ) {
                    createOrder()
                    _uiState.update {
                        currentState.copy(
                            step = currentState.step.next()
                        )
                    }
                }
            }

            null -> {}
        }

    }

    fun previousStep() {
        val currentState = _uiState.value as? PaymentScreenUIState.Content ?: return
        when (currentState.step) {
            Step.Two -> {
                _uiState.update {
                    currentState.copy(
                        step = currentState.step.previous(),
                    )
                }
            }
            else -> {}
        }
    }

}