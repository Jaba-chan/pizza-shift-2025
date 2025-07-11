package ru.evgenykuzakov.pizzadetail.presentation

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.evgenykuzakov.pizza.Dough
import ru.evgenykuzakov.pizza.Ingredient
import ru.evgenykuzakov.pizza.Pizza
import ru.evgenykuzakov.pizza.Size
import ru.evgenykuzakov.pizzadetail.R
import ru.evgenykuzakov.resource.mapToResource
import ru.evgenykuzakov.resource.mapToSizeResource
import ru.evgenykuzakov.resource.mapToTitleResource
import ru.evgenykuzakov.theme.ExtendedTheme
import ru.evgenykuzakov.ui.AppBarIconButton
import ru.evgenykuzakov.ui.ArrowSelector
import ru.evgenykuzakov.ui.BasicAppBar
import ru.evgenykuzakov.ui.Paragraph12Regular
import ru.evgenykuzakov.ui.Paragraph14Medium
import ru.evgenykuzakov.ui.Paragraph14Regular
import ru.evgenykuzakov.ui.Paragraph16Medium
import ru.evgenykuzakov.ui.Paragraph16Regular
import ru.evgenykuzakov.ui.PrimaryButton
import ru.evgenykuzakov.ui.ShiftButtonText
import ru.evgenykuzakov.ui.TabSelector
import ru.evgenykuzakov.ui.TitleH2
import ru.evgenykuzakov.resource.R as Res

@Composable
internal fun AppBar(
    onButtonClick: () -> Unit
) {
    BasicAppBar(
        headingText = stringResource(Res.string.pizza),
        leadingIcon = {
            AppBarIconButton(
                iconResId = Res.drawable.ic_arrow_left,
                onButtonClick = onButtonClick
            )
        }
    )

}

@Composable
internal fun ColumnScope.PizzaImage(
    baseUrl: String,
    img: String
) {
    AsyncImage(
        modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .size(220.dp)
            .padding(bottom = 32.dp),
        model = "$baseUrl$img",
        contentDescription = null
    )
}

@Composable
internal fun PizzaName(
    name: String
) {
    TitleH2(text = name)
}

@Composable
internal fun SizeAndDough(
    size: Size,
    dough: Dough
) {
    Paragraph14Regular(
        modifier = Modifier.padding(vertical = 8.dp),
        text = "${stringResource(size.mapToSizeResource())}, ${stringResource(dough.mapToTitleResource())}",
        color = ExtendedTheme.colorScheme.content3
    )
}

@Composable
internal fun PizzaDescription(
    description: String
) {
    Paragraph16Regular(
        text = description, color = ExtendedTheme.colorScheme.content3
    )
}

@Composable
internal fun SizeSelector(
    sizes: List<Size>,
    selectedSize: Size,
    select: (Int) -> Unit
) {
    TabSelector(
        modifier = Modifier.padding(top = 24.dp, bottom = 12.dp),
        optionsTitle = sizes.map { stringResource(it.mapToTitleResource()) },
        selectedPos = sizes.indexOf(selectedSize),
        onSelectTab = select,
    )
}

@Composable
internal fun ExtrasHeading() {
    Paragraph16Medium(
        modifier = Modifier.padding(bottom = 16.dp),
        text = stringResource(R.string.add_by_taste)
    )
}


@Composable
internal fun IngredientCard(
    url: String,
    toppings: List<Ingredient>,
    ingredient: Ingredient,
    onClick: (Ingredient) -> Unit
) {
    val shape = RoundedCornerShape(12.dp)
    Card(
        modifier = Modifier
            .height(172.dp)
            .shadow(
                elevation = 12.dp,
                spotColor = ExtendedTheme.colorScheme.shadowStrong.copy(alpha = 0.85f),
                shape = RoundedCornerShape(12.dp),
            )
            .let {
                if (ingredient in toppings) it.border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.primary,
                    shape = shape
                )
                else it
            }
            .clickable(
                onClick = { onClick(ingredient) },
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            )
            .clip(shape),
        colors = CardDefaults.cardColors(
            containerColor = ExtendedTheme.colorScheme.backgroundElevation
        )
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .width(IntrinsicSize.Min)
                .wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                modifier = Modifier.size(88.dp),
                model = "$url${ingredient.img}",
                contentDescription = null
            )

            Paragraph12Regular(
                modifier = Modifier
                    .padding(top = 12.dp, bottom = 4.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = stringResource(ingredient.mapToResource())
                    .replaceFirstChar { it.titlecaseChar() }
            )

            Paragraph14Medium(
                text = "${ingredient.price} ${stringResource(Res.string.rub_char)}"
            )
        }
    }
}

@Composable
internal fun ExtrasIngredients(
    url: String,
    ingredients: List<Ingredient>,
    toppings: List<Ingredient>,
    select: (Ingredient) -> Unit
) {
    FlowRow(
        modifier = Modifier.wrapContentHeight(),
        maxItemsInEachRow = 3,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        ingredients.forEach { ingredient ->
            IngredientCard(
                url = url,
                ingredient = ingredient,
                toppings = toppings,
                onClick = { select(it) }
            )
        }
    }
}

@Composable
internal fun ColumnScope.DoughSelector(
    doughs: List<Dough>,
    selectedDough: Dough,
    select: (Int) -> Unit
) {
    ArrowSelector(
        modifier = Modifier.padding(bottom = 16.dp),
        optionsLabel = doughs.map { dough ->
            stringResource(dough.mapToTitleResource()).replaceFirstChar { it.titlecaseChar() }
        },
        onSelectTab = select,
        selectedPos = doughs.indexOf(selectedDough)
    )
}

@Composable
internal fun ColumnScope.AddToCartButton(
    onClick: () -> Unit,
    userChoice: Pizza,
    totalCost: Int
) {
    PrimaryButton(
        modifier = Modifier.align(Alignment.CenterHorizontally).padding(vertical = 16.dp),
        onClick = onClick
    ){
        Icon(
            painter = painterResource(R.drawable.ic_big_plus),
            contentDescription = null,
            tint = ExtendedTheme.colorScheme.buttonContent
        )
        val text = if (userChoice.id == 0L) "$totalCost ${stringResource(Res.string.rub_char)}" else stringResource(R.string.change)
        ShiftButtonText(
            text = text,
        )
    }
}



