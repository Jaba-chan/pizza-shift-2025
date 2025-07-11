package ru.evgenykuzakov.util.visualTransformation

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class CardPanVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val raw = text.text.filter { it.isDigit() }.take(16)

        val formatted = buildString {
            raw.forEachIndexed { index, c ->
                append(c)
                if ((index + 1) % 4 == 0 && index + 1 != raw.length) {
                    append(' ')
                }
            }
        }

        val transformed = AnnotatedString(formatted)

        val offsetMapping = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                val spaceCount = listOf(4, 8, 12).count { it < offset }
                return (offset + spaceCount).coerceAtMost(transformed.length)
            }

            override fun transformedToOriginal(offset: Int): Int {
                val spaceCount = listOf(4, 9, 14).count { it < offset }
                return (offset - spaceCount).coerceAtMost(raw.length)
            }
        }

        return TransformedText(transformed, offsetMapping)
    }
}