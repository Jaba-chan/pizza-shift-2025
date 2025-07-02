package ru.evgenykuzakov.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TitleH2(
    modifier: Modifier = Modifier,
    text: String
){
  Text(
      modifier = modifier,
      text = text,
      style = MaterialTheme.typography.titleMedium,
      color = MaterialTheme.colorScheme.onSurface
  )
}