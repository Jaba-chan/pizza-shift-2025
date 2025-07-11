package ru.evgenykuzakov.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.evgenykuzakov.theme.ExtendedTheme

@Composable
internal fun ShiftButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    height: Dp = 56.dp,
    shape: Shape = RoundedCornerShape(16.dp),
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    border: BorderStroke? = null,
    content: @Composable () -> Unit
){
    Button(
        modifier = modifier.height(height),
        onClick = onClick,
        shape = shape,
        colors = colors,
        border = border
    ) {
        content()
    }
}


@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    shape: Shape = RoundedCornerShape(16.dp),
    content: @Composable () -> Unit
){
    ShiftButton (
        modifier = modifier,
        onClick = onClick,
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = ExtendedTheme.colorScheme.buttonContent,
        )
    ) {
        content()
    }
}

@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    shape: Shape = RoundedCornerShape(16.dp),
    content: @Composable () -> Unit,
){
    ShiftButton (
        modifier = modifier,
        onClick = onClick,
        shape = shape,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = ExtendedTheme.colorScheme.content3,
        )
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