package ru.evgenykuzakov.resource

import ru.evgenykuzakov.pizza.Dough
import ru.evgenykuzakov.pizza.type.DoughType

fun Dough.mapToTitleResource(): Int {
    return when(this.type){
        DoughType.Thick -> R.string.dough_thick
        DoughType.Thin ->  R.string.dough_thin
    }
}
