package ru.evgenykuzakov.auth.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AuthScreen(
    viewModel: AuthScreenViewModel = hiltViewModel(),
    navigateToCatalog: () -> Unit,
    paddingValues: PaddingValues
) {
    val context = LocalContext.current
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.action.collect{
            when(it){
                AuthActions.NavigateToCatalogScreen -> navigateToCatalog()
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        AppBar()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            HeadingText()

            PhoneTextInput(state, viewModel::handlePhoneTextInput)

            state.codeState?.let { CodeTextInput(state, viewModel::handleCodeTextInput) }

            AuthButton(
                state = state ,
                onClick = { if (state.codeState == null) viewModel.auth() else viewModel.signIn() }
            )

            state.codeState?.timer?.let { TimerText(context, it) }

            if (state.codeState?.showResendCodeButton == true){
                RequestAgainTextButton(viewModel::requestCodeAgain )
            }

        }
    }
}