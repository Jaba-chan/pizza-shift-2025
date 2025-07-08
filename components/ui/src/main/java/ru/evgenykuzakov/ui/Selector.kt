package ru.evgenykuzakov.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.evgenykuzakov.theme.ExtendedTheme
import ru.evgenykuzakov.resource.R as Res

@Composable
fun <T> TabSelector(
    modifier: Modifier = Modifier,
    options: List<T>,
    descriptions: List<String>,
    selectedPos: Int,
    select: (Int) -> Unit,
) {
    Row(
        modifier = modifier
            .height(44.dp)
            .background(
                color = ExtendedTheme.colorScheme.backgroundSecondary,
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        options.forEachIndexed { index, _ ->
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(2.dp)
                    .fillMaxSize()
                    .clip(RoundedCornerShape(14.dp))
                    .clickable(
                        onClick = { select(index) },
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() },
                    )
                    .let { if (selectedPos == index) it.background(MaterialTheme.colorScheme.background) else it }
            ) {
                Paragraph14Regular(
                    modifier = Modifier.align(Alignment.Center),
                    text = descriptions[index]
                )
            }
        }
    }
}

@Composable
fun <T> ColumnScope.ArrowSelector(
    modifier: Modifier = Modifier,
    options: List<T>,
    descriptions: List<String>,
    selectedPos: Int,
    select: (Int) -> Unit,
) {
    Row(
        modifier = modifier
            .height(44.dp)
            .width(250.dp)
            .align(Alignment.CenterHorizontally)
            .background(
                color = ExtendedTheme.colorScheme.backgroundSecondary,
                shape = RoundedCornerShape(16.dp)
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Arrow(
            onClick = { select(if (selectedPos > 0) selectedPos - 1 else options.size - 1) }
        )

        Paragraph14Regular(
            textAlign = TextAlign.Center,
            text = descriptions[selectedPos]
        )

        Arrow(
            isLeft = false,
            onClick = { select(if (selectedPos < options.size - 1) selectedPos + 1 else 0) }
        )
    }
}

@Composable
private fun Arrow(
    onClick: () -> Unit,
    isLeft: Boolean = true
) {
    IconButton(
        onClick = onClick
    ) {
        Icon(
            modifier = Modifier
                .size(24.dp)
                .let { if (isLeft) it else it.graphicsLayer(rotationY = 180f) },
            painter = painterResource(Res.drawable.ic_arrow_left),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurface
        )
    }
}