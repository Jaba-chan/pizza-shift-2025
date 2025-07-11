package ru.evgenykuzakov.payment.presentation

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import ru.evgenykuzakov.payment.domain.model.DebitCard
import ru.evgenykuzakov.payment.domain.model.Order
import ru.evgenykuzakov.payment.feature.R
import ru.evgenykuzakov.resource.mapToResource
import ru.evgenykuzakov.resource.mapToSizeResource
import ru.evgenykuzakov.resource.mapToTitleResource
import ru.evgenykuzakov.theme.ExtendedTheme
import ru.evgenykuzakov.ui.AppBarIconButton
import ru.evgenykuzakov.ui.BasicAppBar
import ru.evgenykuzakov.ui.Paragraph12Regular
import ru.evgenykuzakov.ui.Paragraph16Regular
import ru.evgenykuzakov.ui.PrimaryButton
import ru.evgenykuzakov.ui.SecondaryButton
import ru.evgenykuzakov.ui.ShiftButtonText
import ru.evgenykuzakov.ui.ShiftHeadingTextField
import ru.evgenykuzakov.ui.TitleH2
import ru.evgenykuzakov.util.visualTransformation.CardExpireDateVisualTransformation
import ru.evgenykuzakov.util.visualTransformation.CardPanVisualTransformation
import ru.evgenykuzakov.resource.R as Res

@Composable
internal fun AppBar(
    @StringRes headingTextRes: Int,
    onButtonClick: () -> Unit
) {
    BasicAppBar(
        headingText = stringResource(headingTextRes),
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
    PrimaryButton(
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
    PrimaryButton(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick
    ) {
        ShiftButtonText(text = stringResource(R.string.pay))
    }
}

@Composable
internal fun PayWindow(
    debitCard: DebitCard,
    onPanChanged: (String) -> Unit,
    onExpireDateChanged: (String) -> Unit,
    onCVVChanged: (String) -> Unit,
) {
    Card(
        Modifier.padding(vertical = 24.dp),
        colors = CardDefaults.cardColors(
            containerColor = ExtendedTheme.colorScheme.backgroundSecondary
        )
    ) {
        Column(
            Modifier.padding(24.dp)
        ) {
            ShiftHeadingTextField(
                modifier = Modifier.fillMaxWidth(),
                headingText = stringResource(R.string.pan),
                value = debitCard.pan,
                placeholderText = stringResource(R.string.pan_placeholder),
                onTextChanged = {
                    onPanChanged(it.replace(" ", ""))
                },
                maxLength = 16,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                visualTransformation = CardPanVisualTransformation()
            )

            Spacer(Modifier.height(16.dp))

            Row {
                ShiftHeadingTextField(
                    modifier = Modifier.weight(1f),
                    headingText = stringResource(R.string.expire_date),
                    value = debitCard.expireDate,
                    placeholderText = stringResource(R.string.expire_date_placeholder),
                    onTextChanged = onExpireDateChanged,
                    maxLength = 4,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    visualTransformation = CardExpireDateVisualTransformation()
                )

                Spacer(Modifier.width(24.dp))

                ShiftHeadingTextField(
                    modifier = Modifier.weight(1f),
                    headingText = stringResource(R.string.cvv),
                    value = debitCard.cvv,
                    placeholderText = stringResource(R.string.cvv_placeholder),
                    onTextChanged = onCVVChanged,
                    maxLength = 3,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    visualTransformation = PasswordVisualTransformation()
                )
            }
        }
    }
}


@Composable
private fun HeadingText(
    heading: String,
    description: String
) {
    Column {
        Paragraph12Regular(
            modifier = Modifier.fillMaxWidth(),
            text = heading,
            color = ExtendedTheme.colorScheme.content6
        )

        Spacer(Modifier.height(2.dp))

        Paragraph16Regular(
            text = description
        )
    }

}

@Composable
internal fun PaymentSuccessfully(
    order: Order,
    onOrderDetailButtonClick: () -> Unit,
    onMainButtonClick: () -> Unit,
    onCloseClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BasicAppBar(
            trailingIcon = {
                IconButton(
                    onClick = onCloseClick
                ) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(Res.drawable.ic_x),
                        contentDescription = null
                    )
                }
            }
        )

        Image(
            modifier = Modifier
                .padding(vertical = 12.dp)
                .size(80.dp),
            painter = painterResource(R.drawable.success),
            contentDescription = null,
        )

        TitleH2(
            modifier = Modifier.padding(vertical = 24.dp),
            text = stringResource(R.string.payment_successfully)
        )

        val pizzas = order.pizzas.map { pizza ->
            "${pizza.name}, " +
                    "${
                        stringResource(
                            pizza.sizes.first().mapToTitleResource()
                        ).replaceFirstChar { it.lowercaseChar() }
                    } " +
                    "${stringResource(pizza.sizes.first().mapToSizeResource())}, " +
                    stringResource(pizza.doughs.first().mapToTitleResource()) +
                    if (pizza.toppings.isNotEmpty()) {
                        " + " + pizza.toppings.map { stringResource(it.mapToResource()) }
                            .joinToString(", ")
                    } else {
                        ""
                    }
        }

        Column(
            Modifier.padding(vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            HeadingText(
                heading = stringResource(Res.string.order),
                description = pizzas.joinToString("\n")
            )

            val receiverAddress = order.receiverAddress
            val address =
                listOf(
                    receiverAddress.apartment,
                    receiverAddress.street,
                    receiverAddress.house
                )

            HeadingText(
                heading = stringResource(Res.string.delivery_address),
                description = address.joinToString(", ")
            )

            HeadingText(
                heading = stringResource(Res.string.order_sum),
                description = "${order.totalPrice} ${stringResource(Res.string.rub_str_p)}"
            )

            Paragraph12Regular(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.all_info_dublicated_in_sms),
                color = ExtendedTheme.colorScheme.content6
            )
        }

        Column(
            Modifier.padding(bottom = 16.dp)
        ) {

            SecondaryButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = onOrderDetailButtonClick,

                ) {
                ShiftButtonText(
                    color = ExtendedTheme.colorScheme.content3,
                    text = stringResource(Res.string.order_details)
                )
            }

            Spacer(Modifier.height(8.dp))

            PrimaryButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = onMainButtonClick
            ) {
                ShiftButtonText(text = stringResource(R.string.to_main))
            }
        }

    }
}









