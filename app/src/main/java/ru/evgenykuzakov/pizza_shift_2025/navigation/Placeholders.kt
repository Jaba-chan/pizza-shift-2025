package ru.evgenykuzakov.pizza_shift_2025.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.evgenykuzakov.theme.BottomBarItemLabel
import ru.evgenykuzakov.theme.Content6

@Composable
internal fun RowScope.BottomNavigationItem(
    item: NavigationItem,
    currentRoute: String?,
    onClick: () -> Unit
) {
    val selected = currentRoute == item.screen.route
    val color =
        if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.Content6

    NavigationBarItem(
        selected = selected,
        icon = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(item.iconResId),
                    contentDescription = null,
                    tint = color
                )
                Text(
                    text = stringResource(item.titleResId),
                    style = MaterialTheme.typography.BottomBarItemLabel,
                    color = color
                )
            }
        },
        onClick = onClick,
        colors = NavigationBarItemDefaults.colors(
            indicatorColor = Color.Transparent
        ),
    )
}