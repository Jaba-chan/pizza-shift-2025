package ru.evgenykuzakov.cart.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.evgenykuzakov.cart.domain.model.CartItem
import ru.evgenykuzakov.cart.feature.R
import ru.evgenykuzakov.pizza.Pizza
import ru.evgenykuzakov.pizza.totalCost
import ru.evgenykuzakov.resource.mapToResource
import ru.evgenykuzakov.resource.mapToSizeResource
import ru.evgenykuzakov.resource.mapToTitleResource
import ru.evgenykuzakov.theme.ExtendedTheme
import ru.evgenykuzakov.ui.AppBarIconButton
import ru.evgenykuzakov.ui.BasicAppBar
import ru.evgenykuzakov.ui.Paragraph12Regular
import ru.evgenykuzakov.ui.Paragraph12Underline
import ru.evgenykuzakov.ui.Paragraph16Medium
import ru.evgenykuzakov.ui.PrimaryButton
import ru.evgenykuzakov.ui.ShiftAsyncImage
import ru.evgenykuzakov.ui.ShiftButtonText
import ru.evgenykuzakov.resource.R as Res

@Composable
internal fun AppBar(
    onButtonClick: () -> Unit
) {
    BasicAppBar(
        headingText = stringResource(Res.string.cart),
        leadingIcon = {
            AppBarIconButton(
                iconResId = Res.drawable.ic_arrow_left,
                onButtonClick = onButtonClick
            )
        }
    )

}

@Composable
internal fun Divider(
) {
    HorizontalDivider(
        modifier = Modifier.padding(
            vertical = 24.dp,
            horizontal = 16.dp
        ),
        color = MaterialTheme.colorScheme.outline
    )
}

@Composable
internal fun CartItem(
    cartItem: CartItem,
    plusOne: (Pizza) -> Unit,
    minusOne: (Pizza) -> Unit,
    changePizza: (Long) -> Unit
) {
    val pizza = cartItem.pizza
    val sizeTitle =
        stringResource(pizza.size.mapToTitleResource()).replaceFirstChar { it.titlecaseChar() }
    val size = stringResource(pizza.size.mapToSizeResource())
    val dough = stringResource(pizza.dough.mapToTitleResource())
    val toppingsList = pizza.toppings.map { stringResource(it.mapToResource()) }.joinToString(", ")
    val toppings = if (toppingsList.isNotEmpty()) " + $toppingsList" else ""

    Row(
        modifier = Modifier
            .padding(horizontal = 4.dp)
    ) {

        ShiftAsyncImage(
            modifier = Modifier
                .padding(end = 16.dp)
                .size(66.dp),
            img = pizza.img
        )

        Column(
            modifier = Modifier.wrapContentWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Paragraph16Medium(text = pizza.name)

            Paragraph12Regular(
                modifier = Modifier.widthIn(max = 236.dp),
                text = "$sizeTitle $size, $dough$toppings"
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Counter(
                    plusOne = plusOne,
                    minusOne = minusOne,
                    cartItem = cartItem
                )

                Paragraph12Underline(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .clickable(
                            onClick = { changePizza(pizza.id) },
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ),
                    text = stringResource(R.string.change)
                )

                Paragraph16Medium(
                    modifier = Modifier.padding(start = 32.dp),
                    text = "${pizza.totalCost() * cartItem.count} ${stringResource(Res.string.rub_char)}"
                )
            }
        }
    }
}

@Composable
internal fun Counter(
    cartItem: CartItem,
    plusOne: (Pizza) -> Unit,
    minusOne: (Pizza) -> Unit
) {
    Row(
        modifier = Modifier
            .height(24.dp)
            .background(
                color = ExtendedTheme.colorScheme.backgroundSecondary,
                shape = RoundedCornerShape(24.dp)
            )
            .padding(horizontal = 16.dp, vertical = 4.dp)
    ) {
        Paragraph12Regular(
            modifier = Modifier.clickable(
                onClick = { minusOne(cartItem.pizza) },
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ),
            text = stringResource(R.string.minus)
        )

        Paragraph12Regular(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = cartItem.count.toString()
        )

        Paragraph12Regular(
            modifier = Modifier.clickable(
                onClick = { plusOne(cartItem.pizza) },
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ),
            text = stringResource(R.string.plus)
        )
    }
}

@Composable
internal fun MakeOrderBar(
    modifier: Modifier = Modifier,
    total: Int,
    onClick: () -> Unit
) {
    val shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
    Card(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = 30.dp,
                spotColor = ExtendedTheme.colorScheme.shadowStrong,
                shape = shape
            ),
        shape = shape,
        colors = CardDefaults.cardColors(
            containerColor = ExtendedTheme.colorScheme.backgroundElevation

        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Row {
                Paragraph16Medium(text = stringResource(R.string.order_cost))

                Spacer(modifier = Modifier.width(24.dp))

                Paragraph16Medium(
                    text = "$total ${stringResource(Res.string.rub_str_p)}"
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            PrimaryButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = onClick
            ) {
                ShiftButtonText(text = stringResource(R.string.make_order))
            }
        }
    }
}
