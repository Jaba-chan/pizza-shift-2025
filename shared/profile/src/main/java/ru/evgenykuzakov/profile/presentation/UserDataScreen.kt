package ru.evgenykuzakov.profile.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.evgenykuzakov.profile.R
import ru.evgenykuzakov.ui.Paragraph14Regular
import ru.evgenykuzakov.ui.ShiftHeadingTextField
import ru.evgenykuzakov.ui.ShiftTextField
import ru.evgenykuzakov.user.User

@Composable
fun UserProfileDataScreen(
    modifier: Modifier = Modifier,
    user: User,
    inputsHandler: List<((String) -> Unit)?>,
    showMiddleName: Boolean = false
){
    val headings = listOf(
        R.string.last_name,
        R.string.first_name,
        R.string.middle_name,
        R.string.phone,
        R.string.email,
        R.string.city
    )

    val placeholders = listOf(
        R.string.last_name,
        R.string.first_name,
        R.string.middle_name,
        R.string.phone,
        R.string.email,
        R.string.city
    )

    val data = listOf(
        user.lastname,
        user.firstname,
        user.middlename,
        user.phone,
        user.email,
        user.city
    )

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        data.forEachIndexed { index, data ->
            if (!showMiddleName && index == 2) return@forEachIndexed
            val isEditable = index != 3
            val requiredMark = when(index){
                0, 1, 3, 5 -> "*"
                else -> ""
            }

            ShiftHeadingTextField(
                headingText = "${stringResource(headings[index])}$requiredMark",
                value = data ?: "",
                onTextChanged = inputsHandler.getOrNull(index) ?: {},
                placeholderText = if (isEditable) stringResource(placeholders[index]) else "",
                enabled = isEditable,
                readOnly = !isEditable
            )

        }
    }
}