package ru.evgenykuzakov.resource

import ru.evgenykuzakov.model.pizza.Size
import ru.evgenykuzakov.model.pizza.type.SizeType

fun Size.mapToTitleResource(): Int {
    return when(this.type){
        SizeType.Large -> R.string.large_title
        SizeType.Medium -> R.string.medium_title
        SizeType.Small -> R.string.small_title
    }
}

fun Size.mapToSizeResource(): Int {
    return when(this.type){
        SizeType.Large -> R.string.large_size
        SizeType.Medium -> R.string.medium_size
        SizeType.Small -> R.string.small_size
    }
}