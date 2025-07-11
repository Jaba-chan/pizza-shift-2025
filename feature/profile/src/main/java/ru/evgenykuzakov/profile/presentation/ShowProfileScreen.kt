package ru.evgenykuzakov.profile.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.evgenykuzakov.ui.LoadingScreen

@Composable
fun ShowProfileScreen(
    viewModel: ShowProfileScreenViewModel = hiltViewModel(),
    paddingValues: PaddingValues
) {
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) { viewModel.getProfile() }

    val inputsHandler = listOf(
        viewModel::handleLastNameTextInput,
        viewModel::handleFirstNameTextInput,
        viewModel::handleMiddleNameTextInput,
        viewModel::handlePhoneTextInput,
        viewModel::handleEmailTextInput,
        viewModel::handleCityTextInput
    )

    Column(
        Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        AppBar()

        Column(
            Modifier.padding(
                start = 16.dp,
                end = 16.dp,
                top = 24.dp,
                bottom = 16.dp
            ).verticalScroll(rememberScrollState()),
        ) {
            when (val currentState = state) {
                is ShowProfileScreenUIState.Content -> {
                    UserProfileDataScreen(
                        user = currentState.user,
                        inputsHandler = inputsHandler
                    )
                }

                is ShowProfileScreenUIState.Error -> {}
                ShowProfileScreenUIState.Loading -> LoadingScreen()
            }
        }
    }
}