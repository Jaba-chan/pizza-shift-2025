package ru.evgenykuzakov.utils

fun String?.getBaseNavUrl(): String = this?.split("/")?.first() ?: ""
