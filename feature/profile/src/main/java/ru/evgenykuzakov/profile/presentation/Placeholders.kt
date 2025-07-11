package ru.evgenykuzakov.profile.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import ru.evgenykuzakov.ui.AppBarIconButton
import ru.evgenykuzakov.ui.BasicAppBar
import ru.evgenykuzakov.resource.R as Res

@Composable
internal fun AppBar() {
    BasicAppBar(headingText = stringResource(Res.string.profile))
}









