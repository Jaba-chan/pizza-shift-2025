package ru.evgenykuzakov.payment.presentation

import ru.evgenykuzakov.user.User


sealed interface PaymentScreenUIState {

    data class Content(val user: User, val step: Step = Step.StepOne) : PaymentScreenUIState

    data object Loading : PaymentScreenUIState

    data class Error(val message: String) : PaymentScreenUIState
}

sealed class Step(val step: Int){

    data object StepOne: Step(1)

    data object StepTwo: Step(2)

    fun next(): Step? = when (this) {
        StepOne -> StepTwo
        StepTwo -> null
    }

    companion object {
        const val lastStep = 2
    }
}

