package ru.evgenykuzakov.payment.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.evgenykuzakov.payment.R
import ru.evgenykuzakov.theme.ExtendedTheme
import ru.evgenykuzakov.ui.AppBarIconButton
import ru.evgenykuzakov.ui.BasicAppBar
import ru.evgenykuzakov.ui.Paragraph12Regular
import ru.evgenykuzakov.ui.ShiftButton
import ru.evgenykuzakov.ui.ShiftButtonText
import ru.evgenykuzakov.resource.R as Res

@Composable
internal fun AppBar(
    onButtonClick: () -> Unit
) {
    BasicAppBar(
        headingText = stringResource(R.string.your_data),
        leadingIcon = {
            AppBarIconButton(
                iconResId = Res.drawable.ic_arrow_left,
                onButtonClick = onButtonClick
            )
        }
    )
}

@Composable
internal fun ProgressBar(
    modifier: Modifier = Modifier,
    step: Step
) {
    Column(
        modifier = modifier
    ) {

        Paragraph12Regular(
            text = String.format(
                stringResource(R.string.step_of),
                step.step,
                Step.lastStep
            )
        )

        LinearProgressIndicator(
            modifier = Modifier.height(4.dp),
            progress = { step.step.toFloat() / Step.lastStep },
            color = ExtendedTheme.colorScheme.indicator,
            trackColor = ExtendedTheme.colorScheme.indicatorPositive
        )
    }
}

@Composable
internal fun NextStepButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    ShiftButton(
        modifier = modifier,
        onClick = onClick
    ) {
        ShiftButtonText(text = stringResource(Res.string.continue_str))
    }
}

