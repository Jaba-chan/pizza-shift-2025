package ru.evgenykuzakov.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = OrangeBrand,
    onSurface = White,
    outline = Border,
    background = ContentWB,
)

private val LightColorScheme = lightColorScheme(
    primary = OrangeBrand,
    onSurface = ContentWB,
    outline = Border,
    background = White,
)

val ColorScheme.indicator: Color
    @Composable
    get() = if (isSystemInDarkTheme()) IndicatorLight else IndicatorLight

val ColorScheme.Content3: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Content3Color else Content3Color

val ColorScheme.Content5: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Content5Color else Content5Color

val ColorScheme.Content6: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Content6Color else Content6Color

val ColorScheme.ButtonContent: Color
    @Composable
    get() = if (isSystemInDarkTheme()) White else White

@Composable
fun ShiftAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}