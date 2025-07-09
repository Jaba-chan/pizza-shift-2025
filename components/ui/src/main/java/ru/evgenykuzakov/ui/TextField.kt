package ru.evgenykuzakov.ui

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults.Container
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.evgenykuzakov.theme.ExtendedTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShiftTextField(
    modifier: Modifier = Modifier,
    value: String,
    onTextChanged: (String) -> Unit,
    textStyle: TextStyle = MaterialTheme.typography.bodyLarge.copy(),
    enabled: Boolean = true,
    readOnly: Boolean = false,
    singleLine: Boolean = true,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    height: Dp = 48.dp,
    placeholderText: String,
    shape: RoundedCornerShape = RoundedCornerShape(8.dp),
    isError: Boolean = false,

    ) {
    BasicTextField(
        modifier = modifier
            .height(height),
        value = value,
        onValueChange = onTextChanged,
        textStyle = textStyle.copy(
            color = if (!enabled) ExtendedTheme.colorScheme.content5 else MaterialTheme.colorScheme.onSurface
        ),
        enabled = enabled,
        readOnly = readOnly,
        singleLine = singleLine,
        visualTransformation = visualTransformation,
        interactionSource = interactionSource,
    ) { innerTextField ->
        OutlinedTextFieldDefaults.DecorationBox(
            value = value,
            isError = isError,
            innerTextField = innerTextField,
            enabled = enabled,
            singleLine = singleLine,
            visualTransformation = visualTransformation,
            interactionSource = interactionSource,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                disabledTextColor = ExtendedTheme.colorScheme.content5,
                disabledContainerColor = ExtendedTheme.colorScheme.backgroundSecondary
            ),
            contentPadding = TextFieldDefaults.contentPaddingWithoutLabel(
                top = 0.dp,
                bottom = 0.dp,
            ),
            placeholder = {
                Paragraph16Regular(
                    text = placeholderText,
                    color = ExtendedTheme.colorScheme.content5
                )
            },
            container = {
                Container(
                    enabled = enabled,
                    isError = isError,
                    interactionSource = interactionSource,
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                        disabledTextColor = ExtendedTheme.colorScheme.content5,
                        disabledContainerColor = ExtendedTheme.colorScheme.backgroundSecondary
                    ),
                    shape = shape,
                )
            }
        )
    }
}

@Composable
fun ShiftHeadingTextField(
    modifier: Modifier = Modifier,
    headingText: String,
    value: String,
    onTextChanged: (String) -> Unit,
    placeholderText: String,
    enabled: Boolean,
    readOnly: Boolean
){
    Column(modifier = modifier) {

        Paragraph14Regular(text = headingText)

        Spacer(Modifier.height(6.dp))

        ShiftTextField(
            modifier = Modifier.fillMaxSize(),
            value = value,
            onTextChanged = onTextChanged,
            placeholderText = placeholderText,
            enabled = enabled,
            readOnly = readOnly,
        )

    }
}