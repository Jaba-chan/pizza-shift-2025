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
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
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

private val LocalExtendedColors = staticCompositionLocalOf {
    ExtendedColors(
        indicator = Color.Unspecified,
        content3 = Color.Unspecified,
        content5 = Color.Unspecified,
        content6 = Color.Unspecified,
        buttonContent = Color.Unspecified,
    )
}

@Composable
fun ShiftAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
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

    val extendedColors = ExtendedColors(
            indicator = IndicatorLight,
            content3 = Content3Color,
            content5 = Content5Color,
            content6 = Content6Color,
            buttonContent = White,
    )

    CompositionLocalProvider(
        LocalExtendedColors provides extendedColors,
        LocalExtendedTypography provides extendedType
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}

object ExtendedTheme {
    val colorScheme: ExtendedColors
        @Composable
        get() = LocalExtendedColors.current
    val typography: ExtendedType
        @Composable
        get() = LocalExtendedTypography.current
}