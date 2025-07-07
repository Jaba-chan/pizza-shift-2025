package ru.evgenykuzakov.pizzadetail.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PizzaDetailScreen(
    viewModel: PizzaDetailViewModel = hiltViewModel(),
    paddingValues: PaddingValues
) {
    val state by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        AppBar(onButtonClick = {})
        when(state){
            is PizzaDetailScreenUIState.Content ->{
                val pizza = (state as PizzaDetailScreenUIState.Content).pizza

                Column(
                    modifier = Modifier.padding(
                        top = 24.dp,
                        end = 16.dp,
                        start = 16.dp)
                ) {

                    PizzaImage(baseUrl = viewModel.getBaseUrl(), img = pizza.img)

                    PizzaName(pizza.name)

                    SizeAndDough(pizza.sizes.first(), pizza.doughs.first())

                    Ingredients(pizza.ingredients)
                }
            }
            is PizzaDetailScreenUIState.Error -> {}
            PizzaDetailScreenUIState.Loading -> {}
        }

    }
}