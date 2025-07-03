package ru.evgenykuzakov.ui

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShiftTextField(
    modifier: Modifier = Modifier,
    value: String,
    placeholderText: String,
    onTextChanged: (String) -> Unit,
    textStyle: TextStyle = MaterialTheme.typography.bodyLarge,
    enabled: Boolean = true,
    singleLine: Boolean = true,
    isError: Boolean = false,
    height: Dp = 48.dp,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    visualTransformation: VisualTransformation = VisualTransformation.None,
    shape: RoundedCornerShape = RoundedCornerShape(8.dp)
) {
    BasicTextField(
        modifier = modifier
            .height(height),
        value = value,
        onValueChange = onTextChanged,
        singleLine = singleLine,
        interactionSource = interactionSource,
        textStyle = textStyle,
    ) { innerTextField ->
        OutlinedTextFieldDefaults.DecorationBox(
            value = value,
            innerTextField = innerTextField,
            enabled = enabled,
            singleLine = singleLine,
            visualTransformation = visualTransformation,
            interactionSource = interactionSource,
            colors = OutlinedTextFieldDefaults.colors(),
            contentPadding = TextFieldDefaults.contentPaddingWithoutLabel(
                top = 0.dp,
                bottom = 0.dp,
            ),
            placeholder =  {
                Paragraph16(text = placeholderText)
            },
            container = {
                OutlinedTextFieldDefaults.ContainerBox(
                    enabled = enabled,
                    interactionSource = interactionSource,
                    shape = shape,
                    isError = isError,
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = MaterialTheme.colorScheme.outline
                    )
                )
            }
        )
    }
}