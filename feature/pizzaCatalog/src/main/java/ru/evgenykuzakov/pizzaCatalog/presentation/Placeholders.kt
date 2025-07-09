package ru.evgenykuzakov.pizzaCatalog.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.evgenykuzakov.pizza.domain.model.Catalog
import ru.evgenykuzakov.pizzaCatalog.R
import ru.evgenykuzakov.theme.ExtendedTheme
import ru.evgenykuzakov.ui.BasicAppBar
import ru.evgenykuzakov.ui.Paragraph12Regular
import ru.evgenykuzakov.ui.Paragraph16Medium
import ru.evgenykuzakov.resource.R as Res

@Composable
internal fun AppBar() {
    BasicAppBar(headingText = stringResource(Res.string.pizza))
}

@Composable
internal fun PizzaCard(
    pizza: Catalog,
    url: String,
    onCardClick: (String) -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(128.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable(
                onClick = { onCardClick(pizza.id) },
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            )
    ) {
        AsyncImage(
            model = url + pizza.img,
            contentDescription = null
        )

        Spacer(modifier = Modifier.width(24.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Paragraph16Medium(text = pizza.name)

            Paragraph12Regular(text = pizza.description, color = ExtendedTheme.colorScheme.content3)

            Paragraph16Medium(text = String.format(stringResource(R.string.price_from_n), pizza.priceFrom))
        }
    }
}

@Composable
internal fun Catalog(
    catalog: List<Catalog>,
    url: String,
    onCardClick: (String) -> Unit
){
    LazyColumn(
        modifier = Modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        items(catalog) { PizzaCard(pizza = it, url = url, onCardClick = onCardClick) }
    }
}
