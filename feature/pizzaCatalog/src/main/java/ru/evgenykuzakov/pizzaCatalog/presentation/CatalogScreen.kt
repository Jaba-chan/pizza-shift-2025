package ru.evgenykuzakov.pizzaCatalog.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import ru.evgenykuzakov.ui.LoadingScreen

@Composable
fun CatalogScreen(
    viewModel: CatalogViewModel = hiltViewModel(),
    onCardClick: (String) -> Unit,
    paddingValues: PaddingValues
) {
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) { viewModel.getCatalog() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        AppBar()
        when(val currentState = state){
            is CatalogScreenUIState.Content ->
                Catalog(
                    catalog = currentState.catalog,
                    onCardClick = onCardClick
                )
            is CatalogScreenUIState.Error -> {}
            CatalogScreenUIState.Loading -> LoadingScreen()
        }
    }
}