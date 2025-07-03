package ru.evgenykuzakov.theme

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont

val interFontName = GoogleFont("Inter")

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val InterFontFamily = FontFamily(
    Font(googleFont = interFontName, fontProvider = provider, weight = FontWeight.W700),
    Font(googleFont = interFontName, fontProvider = provider, weight = FontWeight.W600),
    Font(googleFont = interFontName, fontProvider = provider, weight = FontWeight.W400)
)