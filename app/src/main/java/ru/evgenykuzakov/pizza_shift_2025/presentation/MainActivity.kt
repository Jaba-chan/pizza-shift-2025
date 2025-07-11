package ru.evgenykuzakov.pizza_shift_2025.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.evgenykuzakov.auth.presentation.AuthScreen
import ru.evgenykuzakov.cart.presentation.CartScreen
import ru.evgenykuzakov.payment.presentation.PaymentScreen
import ru.evgenykuzakov.pizzaCatalog.presentation.CatalogScreen
import ru.evgenykuzakov.pizza_shift_2025.navigation.AppNavGraph
import ru.evgenykuzakov.pizza_shift_2025.navigation.BottomNavigationItem
import ru.evgenykuzakov.pizza_shift_2025.navigation.NavigationItem
import ru.evgenykuzakov.pizza_shift_2025.navigation.NavigationState
import ru.evgenykuzakov.pizza_shift_2025.navigation.Screen
import ru.evgenykuzakov.pizzadetail.presentation.PizzaDetailScreen
import ru.evgenykuzakov.theme.ShiftAppTheme
import ru.evgenykuzakov.utils.getBaseNavUrl

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShiftAppTheme {
                val state by viewModel.uiState.collectAsState()
                val navController = rememberNavController()
                val navSate = NavigationState(navController)

                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route.getBaseNavUrl()

                val bottomNavItems = listOf(
                    NavigationItem.Pizza,
                    NavigationItem.Order,
                    NavigationItem.Cart,
                    NavigationItem.Profile
                )

                LaunchedEffect(Unit){ viewModel.getCartSize() }

                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .navigationBarsPadding(),
                    bottomBar = {
                        if (currentRoute in bottomNavItems.map { it.screen.route }) {
                            Column {
                                HorizontalDivider(color = MaterialTheme.colorScheme.outline)
                                BottomAppBar(
                                    modifier = Modifier.height(60.dp),
                                    containerColor = MaterialTheme.colorScheme.background
                                ) {
                                    bottomNavItems.forEach {
                                        BottomNavigationItem(
                                            item = it,
                                            currentRoute = currentRoute,
                                            onClick = { navSate.navigateTo(it.screen.route) },
                                            cartBadgeCount = state.cartBadge
                                        )
                                    }
                                }
                            }
                        }
                    }
                ) { innerPadding ->
                    AppNavGraph(
                        navHostController = navController,
                        authScreenContent = {
                            AuthScreen(
                                paddingValues = innerPadding,
                                navigateToCatalog = { navSate.navigateTo(Screen.PizzaScreen.route) }
                            )
                        },
                        pizzaCatalogScreenContent = {
                            CatalogScreen(
                                paddingValues = innerPadding,
                                onCardClick = { navSate.navigateTo(Screen.PizzaDetailScreen.createRoute(it)) }
                            )
                        },
                        pizzaDetailScreenContent = {
                            PizzaDetailScreen(
                                paddingValues = innerPadding,
                                navigateBack = { navSate.navigateBack() }
                            )
                        },
                        cartScreenContent = {
                            CartScreen(
                                paddingValues = innerPadding,
                                navigateBack = { navSate.navigateBack() },
                                navigateToChanging = { navSate.navigateTo(Screen.PizzaEditScreen.createRoute(it)) },
                                navigateToPayment = { navSate.navigateTo(Screen.PaymentScreen.route) }
                            )
                        },
                        pizzaEditScreenContent = {
                            PizzaDetailScreen(
                                paddingValues = innerPadding,
                                navigateBack = { navSate.navigateBack() }
                            )
                        },
                        paymentScreenContent = {
                            PaymentScreen(
                                paddingValues = innerPadding,
                                onBackButton = { navSate.navigateBack() },
                                onMainButtonClick = { navSate.navigateTo(Screen.HomeScreen.route) },
                                onOrderDetailButtonClick = { navSate.navigateTo(Screen.OrdersScreen.route) }
                            )
                        }
                    )
                }
            }
        }
    }
}

