package ru.evgenykuzakov.pizza_shift_2025

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.evgenykuzakov.auth.presentation.AuthScreen
import ru.evgenykuzakov.pizza_shift_2025.navigation.AppNavGraph
import ru.evgenykuzakov.theme.ShiftAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShiftAppTheme {
                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                ) { innerPadding ->
                    AppNavGraph(
                        navHostController = navController,
                        authScreenContent = {
                            AuthScreen(
                                paddingValues = innerPadding
                            )
                        }
                    )
                }
            }
        }
    }
}

