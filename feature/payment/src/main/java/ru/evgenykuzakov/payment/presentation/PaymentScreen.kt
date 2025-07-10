package ru.evgenykuzakov.payment.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.evgenykuzakov.payment.feature.R
import ru.evgenykuzakov.profile.presentation.UserProfileDataScreen
import ru.evgenykuzakov.ui.LoadingScreen

@Composable
fun PaymentScreen(
    viewModel: PaymentViewModel = hiltViewModel(),
    paddingValues: PaddingValues,
    navigateBack: () -> Unit
) {
    val state by viewModel.uiState.collectAsState()

    val inputsHandler = listOf(
        viewModel::handleLastNameTextInput,
        viewModel::handleFirstNameTextInput,
        null,
        viewModel::handlePhoneTextInput,
        viewModel::handleEmailTextInput,
        viewModel::handleCityTextInput
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        when (state) {
            is PaymentScreenUIState.Content -> {
                val step = (state as PaymentScreenUIState.Content).step
                val user = (state as PaymentScreenUIState.Content).user

                step?.let {
                    AppBar(
                        headingTextRes = when(step){
                            Step.One -> R.string.your_data
                            Step.Two -> R.string.card_for_pay
                        },
                        onButtonClick = {
                            if (step is Step.One) navigateBack()
                            if (step is Step.Two) viewModel.previousStep()
                        }
                    )
                }


                Column(
                    Modifier
                        .padding(
                            vertical = 24.dp,
                            horizontal = 16.dp
                        )
                        .verticalScroll(rememberScrollState()),
                ) {
                    when (step) {
                        Step.One, Step.Two -> ProgressBar(step = step)
                        null -> {}
                    }

                    when (step) {
                        Step.One -> {
                            UserProfileDataScreen(
                                Modifier
                                    .padding(vertical = 16.dp)
                                    .fillMaxWidth(),
                                user,
                                inputsHandler = inputsHandler
                            )
                        }

                        Step.Two -> {
                            val debitCard = (state as PaymentScreenUIState.Content).debitCard
                            PayWindow(
                                debitCard = debitCard!!,
                                onPanChanged = viewModel::handlePan,
                                onExpireDateChanged = viewModel::handleExpireDate,
                                onCVVChanged = viewModel::handleCVV
                            )
                        }

                        null -> {}
                    }

                    when (step) {
                        Step.One -> NextStepButton(onClick = viewModel::nextStep)
                        Step.Two -> PayButton(onClick = { viewModel.nextStep() })
                        null -> {}
                    }
                }
            }

            is PaymentScreenUIState.Error -> {}
            PaymentScreenUIState.Loading -> LoadingScreen()
        }
    }
}