package ru.evgenykuzakov.cart.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CartScreen(
    viewModel: CartViewModel = hiltViewModel(),
    paddingValues: PaddingValues,
    navigateBack: () -> Unit,
) {
    val state by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        AppBar(onButtonClick = navigateBack)

        Divider()

        when (state) {
            is CartScreenUIState.Content -> {
                val cart = (state as CartScreenUIState.Content).cart

                LazyColumn(
                    modifier = Modifier
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    items(cart){
                        CartItem(
                            url = viewModel.getBaseUrl(),
                            cartItem = it,
                            minusOne = viewModel::deleteOne,
                            plusOne = viewModel::addOne,
                            changePizza = {}
                        )
                    }
                }
            }
            is CartScreenUIState.Error -> {}
            CartScreenUIState.Loading -> {}
        }

    }
}