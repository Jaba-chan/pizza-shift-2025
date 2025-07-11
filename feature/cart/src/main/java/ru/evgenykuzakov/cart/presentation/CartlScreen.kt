package ru.evgenykuzakov.cart.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.evgenykuzakov.pizza.totalCost
import ru.evgenykuzakov.ui.LoadingScreen

@Composable
fun CartScreen(
    viewModel: CartViewModel = hiltViewModel(),
    paddingValues: PaddingValues,
    navigateBack: () -> Unit,
    navigateToChanging: (Long) -> Unit,
    navigateToPayment: () -> Unit
) {
    val state by viewModel.uiState.collectAsState()
    val totalBarHeight = 128.dp

    LaunchedEffect(Unit) { viewModel.updateCart() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            AppBar(onButtonClick = navigateBack)

            Divider()

            when (val currantState = state) {
                is CartScreenUIState.Content -> {
                    LazyColumn(
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp, bottom = totalBarHeight),
                        verticalArrangement = Arrangement.spacedBy(24.dp)
                    ) {
                        items(currantState.cart){ cartItem ->
                            CartItem(
                                cartItem = cartItem,
                                minusOne = viewModel::deleteOne,
                                plusOne = viewModel::addOne,
                                changePizza = { navigateToChanging(it) }
                            )
                        }
                    }
                }
                is CartScreenUIState.Error -> {}
                CartScreenUIState.Loading -> LoadingScreen()
            }
        }

        (state as? CartScreenUIState.Content)?.let { state ->
            val totalPay = state.cart.sumOf { it.pizza.totalCost() * it.count }
            if (totalPay > 0) {
                MakeOrderBar(
                    modifier = Modifier.align(Alignment.BottomCenter),
                    onClick = navigateToPayment,
                    total = totalPay
                )
            }
        }
    }
}