package ru.evgenykuzakov.pizzadetail.presentation

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.evgenykuzakov.model.pizza.Dough
import ru.evgenykuzakov.model.pizza.Ingredient
import ru.evgenykuzakov.model.pizza.Size
import ru.evgenykuzakov.theme.Content3
import ru.evgenykuzakov.ui.AppBarIconButton
import ru.evgenykuzakov.ui.BasicAppBar
import ru.evgenykuzakov.ui.Paragraph14
import ru.evgenykuzakov.ui.Paragraph16
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
){
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
){
    TitleH2(text = name)
}

@Composable
internal fun SizeAndDough(
    size: Size,
    dough: Dough
){
    Paragraph14(text = "${size.type.name}, ${dough.type.name}", color = MaterialTheme.colorScheme.Content3)
}

@Composable
internal fun Ingredients(
    ingredient: List<Ingredient>
){
    Paragraph16(text = ingredient.joinToString(), color = MaterialTheme.colorScheme.Content3)
}

@Composable
internal fun SizeSelector(
    size: Size,
    dough: Dough
){
    Paragraph14(text = "${size.type.name}, ${dough.type.name}", color = MaterialTheme.colorScheme.Content3)
}

