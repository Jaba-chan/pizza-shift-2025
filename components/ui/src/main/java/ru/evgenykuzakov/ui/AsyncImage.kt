package ru.evgenykuzakov.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage


const val BASE_API_URL = "https://shift-intensive.ru/api/"
@Composable
fun ShiftAsyncImage(
    modifier: Modifier = Modifier,
    img: String
) {
    AsyncImage(
        modifier = modifier,
        contentDescription = null,
        model = "${BASE_API_URL}${img}"
    )
}