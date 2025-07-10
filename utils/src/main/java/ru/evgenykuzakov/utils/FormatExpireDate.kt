package ru.evgenykuzakov.utils

fun String.isValidExpiredDate(): Boolean {
    val regex = Regex("^(0[1-9]|1[0-2])/\\d{2}$")
    return regex.matches(this)
}