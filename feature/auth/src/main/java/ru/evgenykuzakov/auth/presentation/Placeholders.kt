package ru.evgenykuzakov.auth.presentation

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.evgenykuzakov.auth.R
import ru.evgenykuzakov.ui.AppBarIconButton
import ru.evgenykuzakov.ui.BasicAppBar
import ru.evgenykuzakov.ui.ButtonProgressIndicator
import ru.evgenykuzakov.ui.Paragraph16
import ru.evgenykuzakov.ui.ShiftButton
import ru.evgenykuzakov.ui.ShiftButtonText
import ru.evgenykuzakov.ui.ShiftTextField

@Composable
internal fun AppBar(){
    BasicAppBar(
        headingText = stringResource(R.string.auth),
        leadingIcon = {
            AppBarIconButton(
                onButtonClick = {},
                iconResId = R.drawable.ic_x
            )
        }
    )
}

@Composable
internal fun HeadingText(){
    Paragraph16(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp),
        text = stringResource(R.string.enter_your_phone_for_login)
    )
}

@Composable
internal fun PhoneTextInput(
    state: AuthScreenUIState,
    onTextChanged: (String) -> Unit
){
    ShiftTextField(
        modifier = Modifier.fillMaxWidth(),
        value = state.phone,
        onTextChanged = onTextChanged,
        placeholderText = stringResource(R.string.phone),
        readOnly = state.codeState != null,
        enabled = state.codeState == null
    )
}

@Composable
internal fun CodeTextInput(
    state: AuthScreenUIState,
    onTextChanged: (String) -> Unit
){
    ShiftTextField(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize()
            .padding(
                top = 16.dp
            ),
        value = state.codeState!!.code,
        onTextChanged = onTextChanged,
        placeholderText = stringResource(R.string.verification_code)
    )
}

@Composable
internal fun AuthButton(
    state: AuthScreenUIState,
    onClick: () -> Unit
){
    ShiftButton(
        modifier = Modifier.fillMaxWidth().padding(top = 24.dp),
        onClick = onClick
    ){
        if (state.codeState?.codeStatus is SentState.Loading || state.phoneStatus is SentState.Loading)
            ButtonProgressIndicator()
        else
            ShiftButtonText(
                text = stringResource(if (state.codeState == null) R.string.continue_str else R.string.login)
            )
    }
}