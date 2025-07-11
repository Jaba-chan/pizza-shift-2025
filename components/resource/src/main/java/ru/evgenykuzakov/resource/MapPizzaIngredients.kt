package ru.evgenykuzakov.resource

import ru.evgenykuzakov.pizza.Ingredient
import ru.evgenykuzakov.pizza.type.IngredientType

fun Ingredient.mapToResource(): Int {
    return when(this.type){
        IngredientType.Bacon -> R.string.bacon
        IngredientType.Basil -> R.string.basil
        IngredientType.Cheddar -> R.string.cheddar
        IngredientType.ChickenFillet -> R.string.chickenfillet
        IngredientType.Chile -> R.string.chile
        IngredientType.Feta -> R.string.feta
        IngredientType.GreenPepper -> R.string.greenpepper
        IngredientType.Ham -> R.string.ham
        IngredientType.Meatballs -> R.string.meatballs
        IngredientType.Mozzarella -> R.string.mozzarella
        IngredientType.Mushrooms -> R.string.mushrooms
        IngredientType.Onion -> R.string.onion
        IngredientType.Parmesan -> R.string.parmesan
        IngredientType.Peperoni -> R.string.peperoni
        IngredientType.Pickle -> R.string.pickle
        IngredientType.Pineapple -> R.string.pineapple
        IngredientType.Shrimps -> R.string.shrimps
        IngredientType.Tomato -> R.string.tomato
    }
}

fun IngredientType.mapToResource(): Int {
    return when(this){
        IngredientType.Bacon -> R.string.bacon
        IngredientType.Basil -> R.string.basil
        IngredientType.Cheddar -> R.string.cheddar
        IngredientType.ChickenFillet -> R.string.chickenfillet
        IngredientType.Chile -> R.string.chile
        IngredientType.Feta -> R.string.feta
        IngredientType.GreenPepper -> R.string.greenpepper
        IngredientType.Ham -> R.string.ham
        IngredientType.Meatballs -> R.string.meatballs
        IngredientType.Mozzarella -> R.string.mozzarella
        IngredientType.Mushrooms -> R.string.mushrooms
        IngredientType.Onion -> R.string.onion
        IngredientType.Parmesan -> R.string.parmesan
        IngredientType.Peperoni -> R.string.peperoni
        IngredientType.Pickle -> R.string.pickle
        IngredientType.Pineapple -> R.string.pineapple
        IngredientType.Shrimps -> R.string.shrimps
        IngredientType.Tomato -> R.string.tomato
    }
}