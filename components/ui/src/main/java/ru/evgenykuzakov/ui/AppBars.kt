package ru.evgenykuzakov.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.evgenykuzakov.theme.indicator

@Composable
fun BasicAppBar(
   leadingIcon: @Composable (() -> Unit)? = null,
   headingText: String
){
    Row(
        modifier = Modifier
            .padding(
                horizontal = 16.dp,
                vertical = 12.dp
            )
            .height(32.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
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
}

@Composable
fun AppBarIconButton(
    onButtonClick: () -> Unit,
    iconContentDesc: String? = null,
    @DrawableRes iconResId: Int,
    iconTint: Color = MaterialTheme.colorScheme.indicator
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