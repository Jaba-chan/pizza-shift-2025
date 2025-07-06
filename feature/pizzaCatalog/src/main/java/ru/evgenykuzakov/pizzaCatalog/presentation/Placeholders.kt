package ru.evgenykuzakov.pizzaCatalog.presentation

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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.evgenykuzakov.pizza.domain.model.Catalog
import ru.evgenykuzakov.pizzaCatalog.R
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
    pizza: Catalog,
    url: String
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(128.dp)
    ) {
        AsyncImage(
            model = url + pizza.img,
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

@Composable
internal fun Catalog(
    catalog: List<Catalog>,
    url: String
){
    LazyColumn(
        modifier = Modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        items(catalog) { PizzaCard(pizza = it, url = url) }
    }
}

@Composable
internal fun LoadingScreen(){
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        CircularProgressIndicator(
            modifier = Modifier
                .size(48.dp)
                .align(Alignment.Center),
            strokeWidth = 2.dp
        )
    }
}