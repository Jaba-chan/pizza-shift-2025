package ru.evgenykuzakov.ui

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.evgenykuzakov.theme.ExtendedTheme

@Composable
fun ShiftButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    height: Dp = 56.dp,
    content: @Composable () -> Unit
){
    Button(
        modifier = modifier.height(height),
        onClick = onClick,
        shape = RoundedCornerShape(16.dp)
    ) {
        content()
    }
}

@Composable
fun ShiftButtonText(
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
    text: String,
    color: Color = ExtendedTheme.colorScheme.buttonContent
){
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = ExtendedTheme.typography.buttonSemibold,
        color = color
    )
}

@Composable
fun ButtonProgressIndicator(){
    CircularProgressIndicator(
        modifier = Modifier.size(24.dp),
        color = ExtendedTheme.colorScheme.buttonContent
    )
}