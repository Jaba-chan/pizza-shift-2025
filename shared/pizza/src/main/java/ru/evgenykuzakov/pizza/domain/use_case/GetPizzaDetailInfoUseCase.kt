package ru.evgenykuzakov.pizza.domain.use_case

import ru.evgenykuzakov.pizza.domain.model.PizzaDetailInfo
import ru.evgenykuzakov.pizza.domain.repository.PizzaRepository
import javax.inject.Inject

class GetPizzaDetailInfoUseCase @Inject constructor(
    private val repository: PizzaRepository
) : suspend (String) -> PizzaDetailInfo by repository::getPizzaById