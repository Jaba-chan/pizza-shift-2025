package ru.evgenykuzakov.auth.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import ru.evgenykuzakov.ui.BasicAppBar

@Composable
fun AuthScreen(
    viewModel: AuthScreenViewModel = hiltViewModel(),
    paddingValues: PaddingValues
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ){
        BasicAppBar(
            headingText = "Авторизация"
        )
    }
}