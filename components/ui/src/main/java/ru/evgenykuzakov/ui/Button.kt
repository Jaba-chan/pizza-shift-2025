package ru.evgenykuzakov.ui

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.evgenykuzakov.theme.ButtonContent
import ru.evgenykuzakov.theme.ButtonSemibold

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
    color: Color = MaterialTheme.colorScheme.ButtonContent
){
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = MaterialTheme.typography.ButtonSemibold,
        color = color
    )
}

@Composable
fun ButtonProgressIndicator(){
    CircularProgressIndicator(
        modifier = Modifier.size(24.dp),
        color = MaterialTheme.colorScheme.ButtonContent
    )
}