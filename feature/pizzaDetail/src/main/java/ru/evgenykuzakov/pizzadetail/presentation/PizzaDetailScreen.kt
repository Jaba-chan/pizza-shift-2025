package ru.evgenykuzakov.pizzadetail.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.evgenykuzakov.resource.mapToTitleResource

@Composable
fun PizzaDetailScreen(
    viewModel: PizzaDetailViewModel = hiltViewModel(),
    paddingValues: PaddingValues,
    onBackClick: () -> Unit
) {
    val state by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        AppBar(onButtonClick = onBackClick)
        when (state) {
            is PizzaDetailScreenUIState.Content -> {
                val pizza = (state as PizzaDetailScreenUIState.Content).pizza
                val userChoice = (state as PizzaDetailScreenUIState.Content).userChoice

                Column(
                    modifier = Modifier
                        .padding(
                            top = 24.dp,
                            end = 16.dp,
                            start = 16.dp
                        )
                        .verticalScroll(rememberScrollState())
                ) {

                    PizzaImage(baseUrl = viewModel.getBaseUrl(), img = pizza.img)

                    PizzaName(pizza.name)

                    SizeAndDough(userChoice.size, userChoice.dough)

                    PizzaDescription(pizza.description)

                    SizeSelector(pizza.sizes, userChoice.size, viewModel::selectPizzaSize)

                    DoughSelector(
                        doughs = pizza.doughs,
                        selectedDough = userChoice.dough,
                        select = { viewModel.selectPizzaDough(it) }
                    )

                    ExtrasHeading()

                    ExtrasIngredients(
                        url = viewModel.getBaseUrl(),
                        ingredients = pizza.ingredients,
                        toppings = userChoice.toppings,
                        select = viewModel::selectExtraIngredient
                    )

                    AddToCartButton(
                        totalCost = viewModel.totalCost(),
                        onClick = {}
                    )
                }
            }

            is PizzaDetailScreenUIState.Error -> {}
            PizzaDetailScreenUIState.Loading -> {}
        }

    }
}