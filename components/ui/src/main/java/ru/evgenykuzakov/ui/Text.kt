package ru.evgenykuzakov.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import ru.evgenykuzakov.theme.Content5

@Composable
fun TitleH2(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onSurface
){
  Text(
      modifier = modifier,
      text = text,
      style = MaterialTheme.typography.titleMedium,
      color = color
  )
}

@Composable
fun Paragraph16(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.Content5
){
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.bodyLarge,
        color = color
    )
}