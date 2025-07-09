package ru.evgenykuzakov.profile.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import ru.evgenykuzakov.profile.R
import ru.evgenykuzakov.ui.Paragraph14Regular
import ru.evgenykuzakov.ui.ShiftTextField
import ru.evgenykuzakov.user.User

@Composable
fun UserProfileDataScreen(
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

    val data = listOf(
        user.lastname,
        user.firstname,
        user.middlename,
        user.phone,
        user.email,
        user.city
    )

    Column {
        data.forEachIndexed { index, data ->
            if (!showMiddleName && index == 2) return@forEachIndexed
            val isEditable = inputsHandler[index] != null
            Column {
                Paragraph14Regular(text = stringResource(headings[index]))
            }
            ShiftTextField(
                value = data ?: "",
                onTextChanged = inputsHandler.getOrNull(index) ?: {},
                placeholderText = "",
                enabled = isEditable,
                readOnly = isEditable
            )
        }
    }
}