package ru.evgenykuzakov.auth.presentation

import android.content.Context
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.evgenykuzakov.auth.R
import ru.evgenykuzakov.theme.ExtendedTheme
import ru.evgenykuzakov.resource.R as Res
import ru.evgenykuzakov.ui.AppBarIconButton
import ru.evgenykuzakov.ui.BasicAppBar
import ru.evgenykuzakov.ui.ButtonProgressIndicator
import ru.evgenykuzakov.ui.Paragraph14Regular
import ru.evgenykuzakov.ui.Paragraph16Regular
import ru.evgenykuzakov.ui.ShiftButton
import ru.evgenykuzakov.ui.ShiftButtonText
import ru.evgenykuzakov.ui.ShiftTextField

@Composable
internal fun AppBar() {
    BasicAppBar(
        headingText = stringResource(R.string.auth),
        leadingIcon = {
            AppBarIconButton(
                onButtonClick = {},
                iconResId = Res.drawable.ic_x
            )
        }
    )
}

@Composable
internal fun HeadingText() {
    Paragraph16Regular(
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
) {
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
) {
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
) {
    ShiftButton(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp),
        onClick = onClick
    ) {
        if (state.codeState?.codeStatus is SentState.Loading || state.phoneStatus is SentState.Loading)
            ButtonProgressIndicator()
        else
            ShiftButtonText(
                text = stringResource(if (state.codeState == null) Res.string.continue_str else R.string.login)
            )
    }
}

@Composable
internal fun TimerText(
    context: Context,
    time: Int
) {
    val sec = context.resources.getQuantityString(
        R.plurals.seconds,
        time,
        time
    )
    Paragraph14Regular(
        modifier = Modifier.padding(top = 16.dp),
        text = "${stringResource(R.string.request_code_again_after_n_sec)} $sec",
        color = ExtendedTheme.colorScheme.content6
    )
}

@Composable
internal fun RequestAgainTextButton(
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxWidth()
    ){
        ShiftButtonText(
            modifier = Modifier
                .padding(top = 24.dp)
                .align(Alignment.Center)
                .clickable(
                    onClick = onClick,
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ),
            text = stringResource(R.string.request_code_again),
            color = MaterialTheme.colorScheme.onSurface,
        )
    }

}