package ru.evgenykuzakov.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

@Composable
fun BasicAppBar(
    onButtonClick: () -> Unit,
    iconContentDesc: String? = null,
    @DrawableRes iconResId: Int,
    iconTint: Color = MaterialTheme.colorScheme.primary
){
    Row {
        IconButton(
            onClick = onButtonClick
        ) {
            Icon(
                painter = painterResource(iconResId),
                contentDescription = iconContentDesc,
                tint = iconTint
            )
        }
    }
}