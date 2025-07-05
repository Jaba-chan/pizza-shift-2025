package ru.evgenykuzakov.pizza.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.evgenykuzakov.pizza.R
import ru.evgenykuzakov.pizza.domain.model.Catalog
import ru.evgenykuzakov.theme.Content3
import ru.evgenykuzakov.ui.BasicAppBar
import ru.evgenykuzakov.ui.Paragraph12
import ru.evgenykuzakov.ui.Paragraph16

@Composable
internal fun AppBar() {
    BasicAppBar(headingText = stringResource(R.string.pizza))
}

@Composable
internal fun LocalParagraph16(
    text: String
){
    Paragraph16(text = text, style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.W500))
}


@Composable
internal fun PizzaCard(
    pizza: Catalog
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(128.dp)
    ) {
        AsyncImage(
            model = pizza.img,
            contentDescription = null
        )

        Spacer(modifier = Modifier.width(24.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            LocalParagraph16(text = pizza.name)

            Paragraph12(text = pizza.description, color = MaterialTheme.colorScheme.Content3)

            LocalParagraph16(text = String.format(stringResource(R.string.price_from_n), pizza.priceFrom))
        }
    }
}