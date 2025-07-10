package ru.evgenykuzakov.util.visualTransformation

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class CardExpireDateVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val raw = text.text.filter { it.isDigit() }.take(4)

        val formatted = buildString {
            raw.forEachIndexed { index, c ->
                append(c)
                if (index == 1 && raw.length > 2) {
                    append('/')
                }
            }
        }

        val transformed = AnnotatedString(formatted)

        val offsetMapping = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                return when {
                    offset <= 1 -> offset
                    offset in 2..4 -> (offset + 1).coerceAtMost(transformed.length)
                    else -> transformed.length
                }
            }

            override fun transformedToOriginal(offset: Int): Int {
                return when {
                    offset <= 2 -> offset
                    offset in 3..5 -> (offset - 1).coerceAtMost(raw.length)
                    else -> raw.length
                }
            }
        }

        return TransformedText(transformed, offsetMapping)
    }
}