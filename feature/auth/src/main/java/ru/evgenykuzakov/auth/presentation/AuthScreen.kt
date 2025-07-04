package ru.evgenykuzakov.auth.presentation

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.evgenykuzakov.auth.R
import ru.evgenykuzakov.ui.AppBarIconButton
import ru.evgenykuzakov.ui.BasicAppBar
import ru.evgenykuzakov.ui.Paragraph16
import ru.evgenykuzakov.ui.ShiftButton
import ru.evgenykuzakov.ui.ShiftTextField
import ru.evgenykuzakov.ui.SpacerHeight16
import ru.evgenykuzakov.ui.SpacerHeight24

@Composable
fun AuthScreen(
    viewModel: AuthScreenViewModel = hiltViewModel(),
    paddingValues: PaddingValues
) {

    val state by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        BasicAppBar(
            headingText = stringResource(R.string.auth),
            leadingIcon = {
                AppBarIconButton(
                    onButtonClick = {},
                    iconResId = R.drawable.ic_x
                )
            }
        )
        SpacerHeight24()
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Paragraph16(
                modifier = Modifier
                    .fillMaxWidth(),
                text = stringResource(R.string.enter_your_phone_for_login)
            )
            SpacerHeight16()
            ShiftTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.phone,
                onTextChanged = { viewModel.onPhoneTextChanged(it) },
                placeholderText = stringResource(R.string.phone),
                )
            SpacerHeight16()
            if (state.codeState != null){
                ShiftTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .animateContentSize(),
                    value = state.codeState!!.code,
                    onTextChanged = { viewModel.onCodeTextChanged(it) },
                    placeholderText = stringResource(R.string.verification_code)
                )
                SpacerHeight24()
            }

            ShiftButton(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource( if (state.codeState== null) R.string.continue_str else R.string.login
                ),
                onClick = {
                    viewModel.apply {
                        if (state.codeState == null) viewModel.sendPhone() else viewModel.sendCode()
                    }
                }
            )
        }
    }
}