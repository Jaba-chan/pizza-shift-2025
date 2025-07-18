package ru.evgenykuzakov.payment.presentation

import ru.evgenykuzakov.payment.domain.model.DebitCard
import ru.evgenykuzakov.payment.domain.model.Order
import ru.evgenykuzakov.user.User


sealed interface PaymentScreenUIState {

    data class Content(
        val user: User,
        val debitCard: DebitCard? = null,
        val order: Order? = null,
        val step: Step? = Step.One
    ) : PaymentScreenUIState

    data object Loading : PaymentScreenUIState

    data class Error(val message: String) : PaymentScreenUIState
}

sealed class Step(val step: Int){

    data object One: Step(1)

    data object Two: Step(2)

    fun next(): Step? = when (this) {
        One -> Two
        Two -> null
    }

    fun previous(): Step? = when (this) {
        One -> null
        Two -> One
    }

    companion object {
        const val lastStep = 2
    }
}

