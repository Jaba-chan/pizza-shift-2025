package ru.evgenykuzakov.pizza.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CatalogScreen(
    viewModel: CatalogViewModel = hiltViewModel(),
    paddingValues: PaddingValues
) {
    val state by viewModel.uiState.collectAsState()
    AppBar()
    when(state){
        is CatalogScreenUIState.Content -> {
            val catalog = (state as CatalogScreenUIState.Content).catalog
            LazyColumn(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                items(catalog) {
                    PizzaCard(pizza = it)
                }
            }
        }
        is CatalogScreenUIState.Error -> {

        }
        CatalogScreenUIState.Loading -> {

        }
    }


}