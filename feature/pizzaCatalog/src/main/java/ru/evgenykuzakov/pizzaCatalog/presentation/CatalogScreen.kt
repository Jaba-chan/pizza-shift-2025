package ru.evgenykuzakov.pizzaCatalog.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CatalogScreen(
    viewModel: CatalogViewModel = hiltViewModel(),
    paddingValues: PaddingValues
) {
    val state by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        AppBar()
        when(state){
            is CatalogScreenUIState.Content -> Catalog((state as CatalogScreenUIState.Content).catalog, viewModel.getBaseUrl())
            is CatalogScreenUIState.Error -> {}
            CatalogScreenUIState.Loading -> LoadingScreen()
        }
    }
}