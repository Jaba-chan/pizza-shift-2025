package ru.evgenykuzakov.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorScheme = darkColorScheme(
    primary = OrangeBrand,
    onSurface = White,
    outline = BorderLight,
    background = ContentWB,
)

private val LightColorScheme = lightColorScheme(
    primary = OrangeBrand,
    onSurface = ContentWB,
    outline = BorderLight,
    background = White,
)

private val LocalExtendedColors = staticCompositionLocalOf {
    ExtendedColors(
        indicator = Color.Unspecified,
        content3 = Color.Unspecified,
        content5 = Color.Unspecified,
        content6 = Color.Unspecified,
        buttonContent = Color.Unspecified,
        backgroundSecondary = Color.Unspecified,
        shadowSmooth = Color.Unspecified,
        shadowStrong = Color.Unspecified,
        backgroundElevation = Color.Unspecified,
        indicatorPositive = Color.Unspecified
    )
}

@Composable
fun ShiftAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme){
        DarkColorScheme
    } else {
        LightColorScheme
    }

    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setNavigationBarColor(
            color = colorScheme.background,
            darkIcons = !darkTheme
        )
    }

    val extendedColors = ExtendedColors(
            indicator = IndicatorLight,
            content3 = if (isSystemInDarkTheme()) Content3ColorDark else Content3ColorLight,
            content5 = if (isSystemInDarkTheme()) Content5ColorDark else Content5ColorLight,
            content6 = Content6Color,
            buttonContent = White,
            backgroundSecondary = if (isSystemInDarkTheme()) BGSecondaryDark else BGSecondaryLight,
            shadowSmooth = ShadowSmooth,
            shadowStrong = ShadowStrong,
            backgroundElevation = if (isSystemInDarkTheme()) BGElevationDark else White,
            indicatorPositive = IndicatorPositive
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