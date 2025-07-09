package ru.evgenykuzakov.theme

import androidx.compose.material3.CardElevation
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class ExtendedColors(
    val indicator: Color,
    val content3: Color,
    val content5: Color,
    val content6: Color,
    val buttonContent: Color,
    val backgroundSecondary: Color,
    val shadowSmooth: Color,
    val shadowStrong: Color,
    val backgroundElevation: Color,
    val indicatorPositive: Color
)