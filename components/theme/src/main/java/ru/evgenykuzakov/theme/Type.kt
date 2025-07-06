package ru.evgenykuzakov.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    titleMedium = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.W700,
        fontSize = TitleH2,
        lineHeight = 24.sp,
        letterSpacing = TitleH2 * 0f
    ),

    bodyLarge =  TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = Body16,
        lineHeight = 24.sp,
        letterSpacing = Body16 * 0f
    ),

    bodyMedium =  TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = Body14,
        lineHeight = 20.sp,
        letterSpacing = Body14 * 0f
    ),

    bodySmall =  TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = Body12,
        lineHeight = 16.sp,
        letterSpacing = Body12 * 0f
    ),
)

val Typography.ButtonSemibold: TextStyle
    get() = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.W600,
        fontSize = Body16,
        lineHeight = 24.sp,
        letterSpacing = Body16 * 0f
    )

val Typography.BottomBarItemLabel: TextStyle
    get() = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W400,
        fontSize = 10.sp,
        lineHeight = 10.sp,
        letterSpacing = 0.sp
    )