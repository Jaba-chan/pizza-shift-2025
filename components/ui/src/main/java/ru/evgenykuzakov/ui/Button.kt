package ru.evgenykuzakov.ui

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.evgenykuzakov.theme.ButtonContent
import ru.evgenykuzakov.theme.ButtonSemibold

@Composable
fun ShiftButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    height: Dp = 56.dp
){
    Button(
        modifier = modifier.height(height),
        onClick = onClick,
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.ButtonSemibold,
            color = MaterialTheme.colorScheme.ButtonContent
        )
    }
}