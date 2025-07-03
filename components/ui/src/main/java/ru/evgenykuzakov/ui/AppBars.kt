package ru.evgenykuzakov.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun BasicAppBar(
   leadingIcon: @Composable (() -> Unit)? = null,
   headingText: String
){
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = 16.dp,
                vertical = 12.dp
            )
    ) {
        if (leadingIcon != null){
            leadingIcon()
            Spacer(modifier = Modifier.width(32.dp))
        }
        TitleH2(
            modifier = Modifier
                .fillMaxWidth(),
            text = headingText
        )
    }
}

@Composable
fun AppBarIconButton(
    onButtonClick: () -> Unit,
    iconContentDesc: String? = null,
    @DrawableRes iconResId: Int,
    iconTint: Color = MaterialTheme.colorScheme.primary
){
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