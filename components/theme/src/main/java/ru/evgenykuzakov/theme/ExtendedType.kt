package ru.evgenykuzakov.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle

@Immutable
data class ExtendedType(
    val buttonSemibold: TextStyle,
    val bottomBarItemLabel: TextStyle
)