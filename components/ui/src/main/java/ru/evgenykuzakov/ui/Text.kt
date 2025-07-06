package ru.evgenykuzakov.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
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
    color: Color = MaterialTheme.colorScheme.onSurface,
    style: TextStyle = MaterialTheme.typography.bodyLarge,
){
    Text(
        modifier = modifier,
        text = text,
        style = style,
        color = color
    )
}

@Composable
fun Paragraph14(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onSurface
){
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        color = color
    )
}

@Composable
fun Paragraph12(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onSurface
){
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.bodySmall,
        color = color
    )
}