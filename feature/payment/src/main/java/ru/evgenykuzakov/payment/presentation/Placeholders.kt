package ru.evgenykuzakov.payment.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
            ),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        LinearProgressIndicator(
            modifier = Modifier
                .height(4.dp)
                .fillMaxWidth(),
            progress = { step.step.toFloat() / Step.lastStep },
            trackColor = ExtendedTheme.colorScheme.indicator,
            color = ExtendedTheme.colorScheme.indicatorPositive,
            drawStopIndicator = {},
            gapSize = (-2).dp
        )
    }
}

@Composable
internal fun NextStepButton(
    onClick: () -> Unit
) {
    ShiftButton(
        modifier = Modifier
            .padding(top = 62.dp)
            .fillMaxWidth(),
        onClick = onClick
    ) {
        ShiftButtonText(text = stringResource(Res.string.continue_str))
    }
}

@Composable
internal fun PayButton(
    onClick: () -> Unit
) {
    ShiftButton(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick
    ) {
        ShiftButtonText(text = stringResource(R.string.pay))
    }
}





